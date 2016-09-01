package com.habieb.listviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by akupeduli on 9/1/16.
 */
public class PilihArrayActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_array);

        context = PilihArrayActivity.this;

        Button btnArrayStatis = (Button) findViewById(R.id.btnArrayStatis);
        btnArrayStatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListStatisActivity.class);
                startActivity(intent);
            }
        });

        Button btnArrayDinamis = (Button) findViewById(R.id.btnArrayDinamis);
        btnArrayDinamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListDinamisActivity.class);
                startActivity(intent);
            }
        });

        Button btnArrayDinamisObject = (Button) findViewById(R.id.btnArrayDinamisObject);
        btnArrayDinamisObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListDinamisObjectActivity.class);
                startActivity(intent);
            }
        });

        Button btnGridArrayDinamisObject = (Button) findViewById(R.id.btnGridArrayDinamisObject);
        btnGridArrayDinamisObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GridDinamisObjectActivity.class);
                startActivity(intent);
            }
        });
    }
}
