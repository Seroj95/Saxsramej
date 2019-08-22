package com.photo.saxsramej;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
String []  addresses ={"gampr95@mail.ru"};
String subject="Ծնորհակալություն գնումների համար";
String emailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent orderIntent=getIntent();
       String userName= orderIntent.getStringExtra("userName");
       String goodsName= orderIntent.getStringExtra("goodsName");
       int quantity=orderIntent.getIntExtra("quantity",0);
double orderPrice=orderIntent.getDoubleExtra("orderPrice",0);
emailText="Անուն  "+userName+"\n"+
        "Պիցցաի անվանումը  "+goodsName+"\n"+
        "քանակը   "+quantity+"\n"+
        "գումարը  "+orderPrice+" դրամ";
        TextView orderTextView=findViewById(R.id.orderTextView);
        orderTextView.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
    }

    }
}
