package com.photo.cafeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {
    private TextView textViewHello;
    private TextView textViewAdditions;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCoffe;
    private String name;
    private String password;
    private StringBuilder  builderAdditions;


private String drink;
//private StringBuilder bulliderAdditions;
//    String optionsOfDrink="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("password")) {
            name = intent.getStringExtra("name");
            password = intent.getStringExtra("password");
        }else{
            name=getString(R.string.app_name);
            password=getString(R.string.default_Password);
        }
        drink=getString(R.string.tea);
        textViewHello=findViewById(R.id.textViewHello);
        String hello=String.format(getString(R.string.hello_user),name);
        textViewHello.setText(hello);
        textViewAdditions=findViewById(R.id.textViewAdditions);

        String additions=String.format(getString(R.string.additions),drink);
        textViewAdditions.setText(additions);

        checkBoxMilk=findViewById(R.id.checkboxMilk);
        checkBoxSugar=findViewById(R.id.checkboxSugar);
        checkBoxLemon=findViewById(R.id.checkboxLemon);
        spinnerTea=findViewById(R.id.spinnerTea);
        spinnerCoffe=findViewById(R.id.spinnerCoffe);
builderAdditions=new StringBuilder();


    }

    public void onChlikChangeDrink(View view) {
        RadioButton  button=(RadioButton )view;
        int id =button.getId();
        if (id==R.id.radioButtonTea){
            drink=getString(R.string.tea);
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffe.setVisibility(View.INVISIBLE);
            checkBoxLemon.setVisibility(View.VISIBLE);
        }else if (id==R.id.radioButtonCoffe){
            drink=getString(R.string.coffe);
            spinnerTea.setVisibility(View.INVISIBLE);
            spinnerCoffe.setVisibility(View.VISIBLE);
            checkBoxLemon.setVisibility(View.INVISIBLE);
        }
        String additions=String.format(getString(R.string.additions),drink);
textViewAdditions.setText(additions);
    }

    public void onClickSendOrder(View view) {
        builderAdditions.setLength(0);
        if (checkBoxMilk.isChecked()){
            builderAdditions.append(getString(R.string.milk)).append(" ");
        }
        if (checkBoxSugar.isChecked()){
            builderAdditions.append(getString(R.string.sugar)).append(" ");
        }
        if (checkBoxLemon.isChecked()&&drink.equals(getString(R.string.tea))){
            builderAdditions.append(getString(R.string.milk)).append(" ");
        }
        String optionOfDrink="";
        if (drink.equals(getString(R.string.tea))){
            optionOfDrink=spinnerTea.getSelectedItem().toString();
        }else {
            optionOfDrink=spinnerTea.getSelectedItem().toString();
        }
        String order =String.format("Անուն:%s\n" +
                "գախտնաբառ %s\n" +
                ":վերցրելեք %s\n ",name,password,drink,optionOfDrink);
        String additions;
     if (builderAdditions.length()>0){
         additions="neabxodite dabavki "+ builderAdditions.toString();
     }else {
         additions="";
     }
     String fuulOrder=order+additions;
Intent intent=new Intent(this,OrderDetailActivity.class);
intent.putExtra("order",fuulOrder);
startActivity(intent);
    }
}
