package com.photo.saxsramej;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
int quantity=0;
Spinner spinner;
ArrayList spinnerArrayList;
ArrayAdapter spinnerAdapter;
HashMap goodsMap;
String goodsName;
double prices;
EditText userNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEditText=findViewById(R.id.namEditText);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList =new ArrayList();
        spinnerArrayList.add("Monaco");
        spinnerArrayList.add("Tashir");
        spinnerArrayList.add("Italiano");
        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap=new HashMap();
        goodsMap.put("Monaco",1200.0);
        goodsMap.put("Tashir",1000.0);
        goodsMap.put("Italiano",2500.0);

    }


    public void increaseQuantity(View view) {
       quantity= quantity+1;
        TextView quantityTextView=findViewById(R.id.quantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText("" +quantity*prices);

    }

    public void decreaseQuantity(View view) {
        quantity--;
        if (quantity<0){
            quantity=0;
        }
        TextView quantityTextView=findViewById(R.id.quantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText("" +quantity*prices);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName=spinner.getSelectedItem().toString();
        prices=(double)goodsMap.get(goodsName);
        TextView priceTextView=findViewById(R.id.priceTextView);
        priceTextView.setText("" +quantity*prices);
        ImageView goodsImageView=findViewById(R.id.goodsImageView);
        switch (goodsName){
            case "Monaco":
                goodsImageView.setImageResource(R.drawable.pizza1);
                break;
            case "Tashir":
                goodsImageView.setImageResource(R.drawable.pizza2);
                break;
            case "Italiano":
                goodsImageView.setImageResource(R.drawable.pizza3);
                break;
                default:
                    goodsImageView.setImageResource(R.drawable.pizza1);
                    break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCard(View view) {
        Order order =new Order();
        order.userName=userNameEditText.getText().toString();
        order.goodsName=goodsName;
        order.quantity=quantity;
        order.orderPrice=prices*quantity;
        Intent orderIntent=new Intent(this,OrderActivity.class);
orderIntent.putExtra("userName", order.userName);
orderIntent.putExtra("goodsName", order.goodsName);
orderIntent.putExtra("quantity", order.quantity);
orderIntent.putExtra("orderPrice", order.orderPrice);
        startActivity(orderIntent);

    }
}

