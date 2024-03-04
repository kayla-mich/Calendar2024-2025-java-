package com.example.calendarpt2;

import static android.util.Log.d;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

public class SecondScreen extends AppCompatActivity{

    String[] item={"August 2024", "September 2024", "October 2024", "November 2024", "December 2024", "January 2025", "February 2025", "March 2025", "April 2025", "May 2025", "June 2025", "July 2025"};
    private FloatingActionButton returnButton;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.second);
        FloatingActionButton returnButton = (FloatingActionButton) findViewById(R.id.backbutton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondScreen.this, MainActivity.class);
                        startActivity(intent);
            }
        });
        autoCompleteTextView=findViewById(R.id.dropdown);
        adapterItems= new ArrayAdapter<String>(this, R.layout.second,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapterItems.getItem(position);
                //String item = AdapterView.getItemAtPosition(position).toString();
                //Toast.makeText(SecondScreen.this, "Item " + Arrays.toString(item), Toast.LENGTH_SHORT).show();
                Toast.makeText(SecondScreen.this, "Item " + selectedItem, Toast.LENGTH_SHORT).show();

            }

        });

        /*autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapterItems.getItem(position);
                // Log the selected item
                Log.d("ItemClicked", "Selected Item: " + selectedItem);
                // Toast to display the selected item
                Toast.makeText(SecondScreen.this, "Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
