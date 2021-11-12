package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BantuDatabase bd;
    ListView listView;
    EditText editText;
    Button tblTambah;

    ArrayAdapter arrayAdapter;
    ArrayList<String>listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listdatamakanan);
        editText=findViewById(R.id.datamakanan);
        tblTambah=findViewById(R.id.tbltambah);

        listviewku= new ArrayList<>();
        tampilkan_makanan();
        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText(MainActivity.this,"Data Tersimpan", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void tampilkan_makanan() {
        Cursor cursor=bd.tampilmenu();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "Record kosong", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext())
            {
            }
        }
    }
}