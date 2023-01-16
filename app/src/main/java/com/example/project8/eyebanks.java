package com.example.project8;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class eyebanks extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyebanks);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(eyebanks.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("DHIRAJ HOSPITAL / SUMANDEEP HOSPITAL",R.string.gujarat,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("A.EDWARD MAUMENEE EYE BANK",R.string.delhi,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("A.G. EYE HOSPITAL",R.string.tamilnadu1,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("AASHRAYA FOUNDATION",R.string.karnataka1,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("ABINAV DRISTI EYE HOSPITAL",R.string.uttarpradesh1,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("AIMS",R.string.kerala,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("BADAM BALAKRISHNA EYE BANK, KAKINADA EYE FOUNDATION",R.string.andhrapradesh,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("BALAJI EYE CARE TRUST",R.string.andhrapradesh1,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("CHALMEDA ANANDRAO INSTITUTE OF MEDICAL SCIENCES",R.string.ts,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("D.B.C.S. DISTRICT HOSPITAL",R.string.ap,"Java",R.drawable.blood1);
        dataList.add(androidData);
        

        adapter = new MyAdapter(eyebanks.this,dataList);
        recyclerView.setAdapter(adapter);
    }

    private void searchList(String text){
        List<DataClass>dataSearchList = new ArrayList<>();
        for(DataClass data : dataList ){
            if(data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if(dataSearchList.isEmpty()){
            Toast.makeText(this,"Not Found", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setSearchList(dataSearchList);
        }
    }
}



