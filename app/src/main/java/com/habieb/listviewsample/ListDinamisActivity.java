package com.habieb.listviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListDinamisActivity extends AppCompatActivity {


    Context context;
    //Membuat penampung data dinamis
    ArrayList<String> arrayListNamaBuah = new ArrayList<>();
    ArrayList<String> arrayListBeratBuah = new ArrayList<>();


    void addBuah(String nama, String berat) {
        arrayListNamaBuah.add(nama);
        arrayListBeratBuah.add(berat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        context = ListDinamisActivity.this;

        //ini pake fungsi
        addBuah("Duku", "15kg");
        addBuah("Salak", "15kg");
        addBuah("Anggur", "15kg");
        addBuah("Mangga", "15kg");

        //Ini gak pake fungsi
//        arrayListNamaBuah.add("Duku");
//        arrayListBeratBuah.add("4kg");
//
//        arrayListNamaBuah.add("Salak");
//        arrayListBeratBuah.add("5kg");
//
//        arrayListNamaBuah.add("Apel");
//        arrayListBeratBuah.add("3kg");
//
//        arrayListNamaBuah.add("Semangka");
//        arrayListBeratBuah.add("7kg");
//
//        arrayListNamaBuah.add("Pisang");
//        arrayListBeratBuah.add("15kg");
//
//        arrayListNamaBuah.add("Rambutan");
//        arrayListBeratBuah.add("0.5kg");

        //Inisialisasi ListView
        ListView listView = (ListView) findViewById(R.id.listView);

        //Membuat Adapter Custom
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                //jumlah data
                return arrayListNamaBuah.size();

            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View itemCustom =
                        getLayoutInflater().inflate(R.layout.item_custom, null);

                //Ambil data dan sajikan di text
                TextView textViewCustom =
                        (TextView) itemCustom.findViewById(R.id.textViewCustom);
                textViewCustom.setText(arrayListNamaBuah.get(position));

                //Ambil data dan sajikan di text content
                TextView textViewCustomContent =
                        (TextView) itemCustom.findViewById(R.id.textViewCustomContent);
                textViewCustomContent.setText(arrayListBeratBuah.get(position));

                return itemCustom;
            }
        };

        //mengatur adapter dengan base adapter
        listView.setAdapter(baseAdapter);


        //Memberi aksi ketika di klik masing2 item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

//                Toast.makeText(context,"Click="+arrayBuah[position],
//                        Toast.LENGTH_SHORT).show();

                //Pindah activity dan mengirim string 'data' di extra
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data", arrayListNamaBuah.get(position));
                startActivity(intent);
            }
        });

    }
}
