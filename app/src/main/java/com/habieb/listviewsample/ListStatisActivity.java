package com.habieb.listviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListStatisActivity extends AppCompatActivity {

    Context context;
    //    //Membuat data
    String arrayBuah[] = {"Duku", "Salak", "Apel", "Semangka", "Pisang"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = ListStatisActivity.this;

        //Inisialisasi ListView
        ListView listView = (ListView) findViewById(R.id.listView);

        //Membuat Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,
                R.layout.item_list, arrayBuah);

        //Mengatur adapter
        listView.setAdapter(arrayAdapter);

        //Memberi aksi ketika di klik masing2 item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

//                Toast.makeText(context,"Click="+arrayBuah[position],
//                        Toast.LENGTH_SHORT).show();

                //Pindah activity dan mengirim string 'data' di extra
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data", arrayBuah[position]);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
