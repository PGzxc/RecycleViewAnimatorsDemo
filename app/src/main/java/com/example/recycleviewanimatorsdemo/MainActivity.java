package com.example.recycleviewanimatorsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.example.recycleviewanimatorsdemo.activity.AdapterSampleActivity;
import com.example.recycleviewanimatorsdemo.activity.AnimatorSampleActivity;

public class MainActivity extends AppCompatActivity {

    private  boolean enabledGrid=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener();
    }

    private void setListener() {

        findViewById(R.id.btn_animator_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, AnimatorSampleActivity.class);
                intent.putExtra("GRID",enabledGrid);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_adapter_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AdapterSampleActivity.class);
                intent.putExtra("GRID",enabledGrid);
                startActivity(intent);
            }
        });

        ((SwitchCompat)findViewById(R.id.grid)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                enabledGrid=isChecked;
            }
        });

    }
}
