package com.example.calendarpt2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity{

    String[] item={"August 2024", "September 2024", "October 2024", "November 2024", "December 2024", "January 2025", "February 2025", "March 2025", "April 2025", "May 2025", "June 2025", "July 2025"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.second);
        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems= new ArrayAdapter<String>(this, R.layout.list,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = AdapterView.getItemAtPosition(position).toString();
                Toast.makeText(SecondScreen.this, "Item " + item, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
