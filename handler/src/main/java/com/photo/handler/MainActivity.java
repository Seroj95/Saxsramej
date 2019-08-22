package com.photo.handler;

import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTimer;
    private int seccond = 0;
    private boolean isRuning = false;
    private boolean wasRuning=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textView);

        if (savedInstanceState !=null){
            wasRuning=savedInstanceState.getBoolean("wasRuning");
        }
//       seccond= savedInstanceState.getInt("seconds");
//      isRuning=  savedInstanceState.getBoolean("isRuning");
        runTimer();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putInt("seconds",seccond);
//        outState.putBoolean("isRuning",isRuning);
        outState.putBoolean("wasRuning",wasRuning);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

   

    @Override
    protected void onPause() {
        super.onPause();
        wasRuning=isRuning;
        isRuning=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRuning=wasRuning;
    }

    public void onClickStartTimer(View view) {
        isRuning = true;
    }

    public void onClickStopTimer(View view) {
        isRuning = false;
    }

    public void onClickResetTimer(View view) {
        isRuning = false;
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seccond / 3600;
                int minuts = (seccond % 3600) / 60;
                int secs = seccond % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minuts, secs);
                textViewTimer.setText(time);
                if (isRuning) {
                    seccond++;
                }
                handler.postDelayed(this,10);
            }
        });


    }
}