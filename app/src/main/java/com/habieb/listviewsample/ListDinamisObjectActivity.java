package com.habieb.listviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListDinamisObjectActivity extends AppCompatActivity {


    Context context;
    //Membuat penampung data dinamis
    ArrayList<BuahObject> arrayListBuahObject = new ArrayList<>();

    void addBuah(String nama, String berat, int imageResId) {
        BuahObject buahObject = new BuahObject(nama, berat, imageResId);

        arrayListBuahObject.add(buahObject);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        context = ListDinamisObjectActivity.this;

        addBuah("Duku", "15kg", R.drawable.gambar1);
        addBuah("Salak", "15kg", R.drawable.gambar2);
        addBuah("Anggur", "15kg", R.drawable.gambar3);
        addBuah("Mangga", "15kg", R.drawable.gambar4);

        //Inisialisasi ListView
        ListView listView = (ListView) findViewById(R.id.listView);

        //Membuat Adapter Custom
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                //jumlah data
                return arrayListBuahObject.size();
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
                textViewCustom.setText(arrayListBuahObject.get(position).getNama());

                //Ambil data dan sajikan di text content
                TextView textViewCustomContent =
                        (TextView) itemCustom.findViewById(R.id.textViewCustomContent);
                textViewCustomContent.setText(arrayListBuahObject.get(position).getBerat());

                ImageView imageViewCustom =
                        (ImageView) itemCustom.findViewById(R.id.imageViewCustom);
                imageViewCustom.setImageResource(
                        arrayListBuahObject.get(position).getImageResId());

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
                intent.putExtra("data", arrayListBuahObject.get(position).getNama());
                intent.putExtra("gambar", arrayListBuahObject.get(position).getImageResId());

                startActivity(intent);
            }
        });

    }
}
