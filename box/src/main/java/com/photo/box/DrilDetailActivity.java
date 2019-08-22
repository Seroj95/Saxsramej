package com.photo.box;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrilDetailActivity extends AppCompatActivity {
private TextView textViewTitle;
private TextView textViewInfo;
private ImageView  imageViewDril;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dril_detail);
        textViewTitle=findViewById(R.id.textViewTitle);
        textViewInfo=findViewById(R.id.textViewInfo);
        imageViewDril=findViewById(R.id.imageViewDril);
        Intent intent = getIntent();
        if (intent.hasExtra("title")&&intent.hasExtra("info")&&intent.hasExtra("resId")){

            String title=intent.getStringExtra("title");
            String info=intent.getStringExtra("info");
            int resId=intent.getIntExtra("resId",0);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDril.setImageResource(resId);

        }else {

            Intent backToCategory=new Intent(this,DrilCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}
