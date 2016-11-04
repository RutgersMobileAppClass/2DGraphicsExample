package com.example.instructor.a2dgraphicsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveClick(View view) {

        final CustomView customView = (CustomView) findViewById(R.id.customView);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    customView.startTheAnimation();
                }

            }
        });

        thread.start();

    }
}
