package com.example.recycleviewanimatorsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.recycleviewanimatorsdemo.R;
import com.example.recycleviewanimatorsdemo.adapter.MainAdapter;
import com.example.recycleviewanimatorsdemo.bean.DataUtils;
import com.example.recycleviewanimatorsdemo.emun.AdapterType;

import java.util.ArrayList;
import java.util.Arrays;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;

/**
 * author：Admin
 * date：2017/11/2118:31
 * 编程使我快乐
 */

public class AdapterSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_sample);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        if (getIntent().getBooleanExtra("GRID", true)) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (AdapterType type : AdapterType.values()) {
            spinnerAdapter.add(type.name());
        }
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AnimationAdapter adapter = AdapterType.values()[position].get(AdapterSampleActivity.this);
                adapter.setFirstOnly(true);
                adapter.setDuration(500);
                adapter.setInterpolator(new OvershootInterpolator(.5f));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        recyclerView.setItemAnimator(new FadeInAnimator());
        MainAdapter adapter = new MainAdapter(this, new ArrayList<>(Arrays.asList(DataUtils.data)));
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        alphaAdapter.setFirstOnly(true);
        alphaAdapter.setDuration(500);
        alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
        recyclerView.setAdapter(alphaAdapter);
    }
}
