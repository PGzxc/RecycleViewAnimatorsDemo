package com.example.recycleviewanimatorsdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.recycleviewanimatorsdemo.R;
import com.example.recycleviewanimatorsdemo.adapter.MainAdapter;
import com.example.recycleviewanimatorsdemo.bean.DataUtils;
import com.example.recycleviewanimatorsdemo.emun.Type;
import java.util.ArrayList;
import java.util.Arrays;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * @author：Admin
 * date：2017/11/2118:11
 * 编程使我快乐
 */

public class AnimatorSampleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_sample);

        Toolbar toolbar= (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView= (RecyclerView) findViewById(R.id.recycleView);

        if(getIntent().getBooleanExtra("GRID",true)){
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        mainAdapter=new MainAdapter(this,new ArrayList<>(Arrays.asList(DataUtils.data)));
        recyclerView.setAdapter(mainAdapter);

        setListener();

    }

    private void setListener() {

        Spinner spinner= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<String>(AnimatorSampleActivity.this,android.R.layout.simple_list_item_1);
        for(Type type:Type.values()){
            spinnerAdapter.add(type.name());
        }
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView.setItemAnimator(Type.values()[position].getAnimator());
                recyclerView.getItemAnimator().setAddDuration(500);
                recyclerView.getItemAnimator().setRemoveDuration(500);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAdapter.add("newly added item",1);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAdapter.remove(1);
            }
        });

    }
}
