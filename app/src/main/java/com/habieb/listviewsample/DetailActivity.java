package com.habieb.listviewsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akupeduli on 9/1/16.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Munculkan Tombol Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Mengambil data dari extra dan menyajikannya di tex detail
        TextView textViewDetail = (TextView) findViewById(R.id.textViewDetail);
        textViewDetail.setText(getIntent().getStringExtra("data"));

        //Inisialisasi imageview
        ImageView imageView = (ImageView) findViewById(R.id.imageViewDetail);
        imageView.setImageResource(getIntent().getIntExtra("gambar",0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Aksi tombol back
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.menu_settings1) {
            Toast.makeText(DetailActivity.this, "Settings 1", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
