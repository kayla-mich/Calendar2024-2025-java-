package com.example.calendarpt2;

import static android.util.Log.d;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class SecondScreen extends AppCompatActivity{

    String[] item={"August 2024", "September 2024", "October 2024", "November 2024", "December 2024", "January 2025", "February 2025", "March 2025", "April 2025", "May 2025", "June 2025", "July 2025"};
    private FloatingActionButton returnButton;
    private Button enterButton;
    CalendarView calenview;
    Calendar calendar;
    TextView textView;
    TextView MonthInfo;
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.second);
        FloatingActionButton returnButton = (FloatingActionButton) findViewById(R.id.backbutton);
        calenview = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();
         textView = findViewById(R.id.textview1);
        MonthInfo=findViewById(R.id.monthInfo);
        enterButton= findViewById(R.id.EnterBTN);
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
        //Set the circle on the date you want see first
        setDate( 12,  8,  2024);
        getDate();




         calenview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(SecondScreen.this,   (month+ 1) + "/" + dayOfMonth + "/"+ year, Toast.LENGTH_SHORT).show();
            }
        });

     enterButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar laborDay = Calendar.getInstance();
             laborDay.set(2024, 9, 12);
            if ((calendar.get(Calendar.YEAR) == laborDay.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_MONTH) == laborDay.get(Calendar.DAY_OF_MONTH))) {

                MonthInfo.setText("September 2024: "+" 9/2/24- Labor Day (NO SCHOOL)" +  "9/3/24- Staff PD (NO SCHOOL)");
                System.out.println(calenview.getDate());

                ;
            }
            if (calenview.getDate() == (8/12/2024)) {
                System.out.println(calenview.getDate());

                ;
            }



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

    public void setDate(int dayOfMonth, int month, int year){
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        long milli=calendar.getTimeInMillis();
        calenview.setDate(milli);
    }

    public void getDate(){
        long date= calenview.getDate();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date= simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
    }





}
