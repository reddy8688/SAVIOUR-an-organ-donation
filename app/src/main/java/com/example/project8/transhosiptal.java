package com.example.project8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class transhosiptal extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transhosiptal);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(transhosiptal.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Institute of Heart-Lung Transplant and Mechanical Circulatory Support",R.string.tran1,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Pace Hospitals - Kidney and Liver Transplant Centre",R.string.tran2,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Heart Transplant Surgery Hospital in Chennai",R.string.tran3,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Rela Hospital - Multispeciality Hospital in Chennai, India ",R.string.tran4,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Dr. Sandeep Attawar cardiac surgeon",R.string.tran5,"Java",R.drawable.blood1);
        dataList.add(androidData);



        adapter = new MyAdapter(transhosiptal.this,dataList);
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