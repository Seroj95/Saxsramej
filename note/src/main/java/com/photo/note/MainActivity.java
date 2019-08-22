package com.photo.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerViewNotes;
public static final ArrayList<Note>notes=new ArrayList<>();
RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        if (notes.isEmpty()) {
            notes.add(new Note("Seroj", "Grigoryan", "erkushabti", 4));
            notes.add(new Note("poxos", "Grigoryan", "erkushabti", 2));
            notes.add(new Note("Martiros", "Grigoryan", "erkushabti", 1));
            notes.add(new Note("Ponj", "Grigoryan", "erkushabti", 3));
            adapter = new NotesAdapter(notes);
        }
//recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//recyclerViewNotes.setLayoutManager(new  GridLayoutManager(this,3));
            recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewNotes.setAdapter(adapter);

        }

    public void onClickAddNote(View view) {

        Intent intent=new Intent(this,AddNoteActivity.class);

        startActivity(intent);
    }
}
