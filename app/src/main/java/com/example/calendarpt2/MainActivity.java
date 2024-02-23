package com.example.calendarpt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   private Button continueB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*EdgeToEdge.enable(this);
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homescreen), (v, insets) -> {
           Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        continueB=(Button)findViewById(R.id.firstbutton);
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            //when you click the button it switches to the second screen
            public void onClick(View v) {
                openSecondScreen();
            }
        });

        public void openSecondScreen(){
            Intent intent = new Intent(this, SecondScreen.class);
            startActivity(intent);
        }

    }


}