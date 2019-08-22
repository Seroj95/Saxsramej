package com.photo.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {
private EditText editTextTitle;
private EditText editTextDescreption;
private Spinner spinnerDaysOfWeak;
private RadioGroup radioGroupPriorety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
editTextTitle=findViewById(R.id.editText);
editTextDescreption=findViewById(R.id.editTextDexcreption);
spinnerDaysOfWeak=findViewById(R.id.spinnerDaysofWeak);
radioGroupPriorety=findViewById(R.id.radioGrupProreti);

    }

    public void onClicksaveNote(View view) {
String title=editTextTitle.getText().toString().trim();
String descreption=editTextDescreption.getText().toString().trim();
String dayOfWeek=spinnerDaysOfWeak.getSelectedItem().toString();
int radioButtonId=radioGroupPriorety.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(radioButtonId);
        int priroity=Integer.parseInt(radioButton.getText().toString());
        Note note =new Note(title,descreption,dayOfWeek,priroity);
        MainActivity.notes.add(note);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
