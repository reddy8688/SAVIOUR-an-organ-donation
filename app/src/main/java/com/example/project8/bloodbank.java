package com.example.project8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class bloodbank extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass>dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(bloodbank.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Kamineni Hospitals Private Limited Blood Bank",R.string.blood1,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Star Hospitals Blood Bank",R.string.blood2,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Janani Volunteer blood Bank",R.string.blood3,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("St.Theresa's Hospital Blood Bank ",R.string.blood4,"Java",R.drawable.blood2);
        dataList.add(androidData);

        androidData = new DataClass("Adithya Hospital Blood Bank",R.string.blood5,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("MSN Blood Centre",R.string.blood6,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("Jeevan Jyothi Voluntary Blood Bank",R.string.blood7,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("SANGAM BLOOD BANK",R.string.blood8,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("Rct Blood Bank",R.string.blood9,"Java",R.drawable.blood1);
        dataList.add(androidData);

        androidData = new DataClass("Slms Hospital Blood Bank",R.string.blood10,"Java",R.drawable.blood1);
        dataList.add(androidData);


        adapter = new MyAdapter(bloodbank.this,dataList);
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