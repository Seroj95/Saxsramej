package com.photo.pizzarecips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PizzaRecipesItem> arrayList=new ArrayList<>();
        arrayList.add(new PizzaRecipesItem(R.drawable.pizza6,Utils.TITLE,Utils.DESCREPTION,Utils.RECIPE));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter=new PizzaRecipesAdapter(arrayList,this);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
