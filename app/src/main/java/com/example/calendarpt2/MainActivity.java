package com.example.calendarpt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button continueB = findViewById(R.id.firstbutton);
        continueB.setOnClickListener(new OnClickListener() {
            @Override
            //when you click the button it switches to the second screen
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondScreen.class);

                startActivity(intent);
            }


        });


    }
}