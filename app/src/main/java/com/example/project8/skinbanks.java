package com.example.project8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class skinbanks extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skinbanks);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(skinbanks.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("GANGA HOSPITAL",R.string.tamilnadu,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("CHOITHRAM HOSPITAL",R.string.madhyapradesh,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("KLES ROTARY SKIN BANK",R.string.karnataka,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("SUM HOSPITAL SKIN BANK",R.string.odisha,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("BSES SKIN COLLECTION CENTRE",R.string.maharashtra,"Java",R.drawable.blood1);
        dataList.add(androidData);



        adapter = new MyAdapter(skinbanks.this,dataList);
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