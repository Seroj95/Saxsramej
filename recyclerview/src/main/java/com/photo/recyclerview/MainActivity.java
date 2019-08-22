package com.photo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private  RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<RecyclerViewItem>recyclerViewItems=new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_mood_bad_black_24dp,"Seroj","Real") );
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp,"poxos","Val") );
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp,"Ramos","Mad") );
recyclerView=findViewById(R.id.recyclerView);
recyclerView.setHasFixedSize(true);

adapter=new RecyclerViewAdapter(recyclerViewItems) ;
layoutManager=new LinearLayoutManager(this);
recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(layoutManager);

    }
}
