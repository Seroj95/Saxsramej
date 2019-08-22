package com.photo.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("mySharedPreferenc", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("newhelloText","HelloSharedPreferenc");
//        editor.apply();
        textView=findViewById(R.id.textview);
        textView.setText(sharedPreferences.getString("newhelloText","DefaultText"));
    }

    }







//        textView=findViewById(R.id.textview);
//        Log.d("Life method","onCreate");
//        textView.append("onCretae"+"\n");
//
//        if (savedInstanceState!=null){
//            textView.setText(savedInstanceState.getString());
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("Life method","onStart");
//        textView.append("onStart"+"\n");
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        Log.d("Life method","onPostResume");
//        textView.append("onPostResume"+"\n");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("Life method","onPause");
//        textView.append("onPause"+"\n");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("Life method","onStop");
//        textView.append("onStop"+"\n");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("Life method","onDestroy");
//        textView.append("onDestroy"+"\n");
//    }
//
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("textBundle",textView.getText().toString());
//        Log.d("onSaveInstanceState","onSaveInstanceState");
//        textView.append("onSaveInstanceState"+"\n");
//    }
//}
