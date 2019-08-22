package com.photo.note2;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescreption;
    private Spinner spinnerDaysOfWeak;
    private RadioGroup radioGroupPriorety;
//    private NotesDatabase database;
private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
//        database = NotesDatabase.getInstance(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.hide();


        } else {
            Toast.makeText(this, "To esim e", Toast.LENGTH_SHORT).show();
        }

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescreption = findViewById(R.id.editTextDexcreption);
        spinnerDaysOfWeak = findViewById(R.id.spinnerDaysofWeak);
        radioGroupPriorety = findViewById(R.id.radioGrupProreti);
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

    }

    public void onClicksaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String descreption = editTextDescreption.getText().toString().trim();

       int daysOfWeak = spinnerDaysOfWeak.getSelectedItemPosition();
        int radioButtonId = radioGroupPriorety.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int priorety = Integer.parseInt(radioButton.getText().toString());

        if (isFilled(title, descreption)) {
            Note note = new Note(title, descreption, daysOfWeak, priorety);
//            database.notesDao().insertNote(note);
            viewModel.insertNode(note);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Uf sxalem ere", Toast.LENGTH_SHORT).show();
        }

    }



//        Note note=new Note(title,daysOfWeak,descreption,priorety);
//        MainActivity.notes.add(note);
//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);

private  boolean isFilled(String title,String descreption){
        return  !title.isEmpty()&& !descreption.isEmpty();

}
}
