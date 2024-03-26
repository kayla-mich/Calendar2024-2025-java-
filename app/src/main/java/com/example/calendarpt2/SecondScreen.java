
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


    //New
    private Calendar selectedDate;


    private FloatingActionButton returnButton;
    private FloatingActionButton returnButton2;
    private Button enterButton;
    CalendarView calenview;
    Calendar calendar;
    TextView textView;
    TextView MonthInfo;
    AutoCompleteTextView autoCompleteTextView;


    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //New
        selectedDate = Calendar.getInstance();




        setContentView(R.layout.second);
        calenview = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();
        textView = findViewById(R.id.textview1);
        MonthInfo=findViewById(R.id.monthInfo);
        enterButton= findViewById(R.id.EnterBTN);
        returnButton2= (FloatingActionButton) findViewById(R.id.backbutton);
        returnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SecondScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });






      /*
      calenview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               Toast.makeText(SecondScreen.this,   (month+ 1) + "/" + dayOfMonth + "/"+ year, Toast.LENGTH_SHORT).show();
           }




       });
        */
        calenview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                // Display the selected date in a toast message
                Toast.makeText(SecondScreen.this, (month + 1) + "/" + dayOfMonth + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });




        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Set the circle on the date you want see first
                /*  setDate( 12,  8,  2024);




                 long selectedDateMillis = calenview.getDate();
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.setTimeInMillis(selectedDateMillis);
                */
                long selectedDateMillis = selectedDate.getTimeInMillis();


                 calenview.setDate(selectedDateMillis);


                // Print the selected date to logcat
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                String formattedDate = dateFormat.format(selectedDate.getTime());


                // Set the selected date in the CalendarView
                Log.d("SelectedDate", "Selected date: " + formattedDate);
                setDate(selectedDate.get(Calendar.DAY_OF_MONTH), selectedDate.get(Calendar.MONTH)+1, selectedDate.get(Calendar.YEAR));

                //Check for January 2025 events
                if (selectedDate.get(Calendar.MONTH) == Calendar.JANUARY && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 1) {
                        MonthInfo.setText("January 2025:\n1/1/25 - 1/3/25- Winter Break (NO SCHOOL) \n 1/1/25- New Year's Day (NO SCHOOL)");
                    }else if(dayOfMonth == 2){
                        MonthInfo.setText("January 2025:\n1/1/25 - 1/3/25- Winter Break (NO SCHOOL)");
                    }else if(dayOfMonth == 3){
                        MonthInfo.setText("January 2025:\n1/1/25 - 1/3/25- Winter Break (NO SCHOOL)");
                    }else if(dayOfMonth == 6){
                        MonthInfo.setText("January 2025:\n1/6/25- Staff PD (NO SCHOOL)");
                    }else if(dayOfMonth == 20){
                        MonthInfo.setText("January 2025:\n1/20/25- MLK Jr. Day (NO SCHOOL)");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for February 2025 events
               else  if (selectedDate.get(Calendar.MONTH) == Calendar.FEBRUARY && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 14) {
                        MonthInfo.setText("February 2025:\n2/14/25- Staff PD (NO SCHOOL)\n\n Valentine's Day (NO SCHOOL)\n");
                    }else if(dayOfMonth == 17){
                        MonthInfo.setText("February 2025:\n2/17/25- President’s Day (NO SCHOOL)\n");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for March 2025 events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.MARCH && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 10) {
                        MonthInfo.setText("March 2025:\n3/10/25 - 3/14/25- Spring Break (NO SCHOOL)");
                    }else if(dayOfMonth ==11){
                        MonthInfo.setText("March 2025:\n3/10/25 - 3/14/25- Spring Break (NO SCHOOL)");
                    }else if(dayOfMonth == 12){
                        MonthInfo.setText("March 2025:\n3/10/25 - 3/14/25- Spring Break (NO SCHOOL)");
                    }else if(dayOfMonth == 13){
                        MonthInfo.setText("March 2025:\n3/10/25 - 3/14/25- Spring Break (NO SCHOOL)");
                    }else if(dayOfMonth == 14){
                        MonthInfo.setText("March 2025:\n3/10/25 - 3/14/25- Spring Break (NO SCHOOL)");
                    }else if(dayOfMonth == 31){
                        MonthInfo.setText("March 2025:\n3/31/25- Chavez Huerta Day (NO SCHOOL)");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for April 2025 events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.APRIL && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 18) {
                        MonthInfo.setText("April 2025:\n4/18/25- Spring Holiday (NO SCHOOL)");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for May 2025 events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.MAY && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 2) {
                    MonthInfo.setText("May 2025:\n5/2/25- Staff PD (NO SCHOOL)");
                    }else if(dayOfMonth == 26){
                        MonthInfo.setText("May 2025:\n5/26/25- Memorial Day (NO SCHOOL)");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for June 2025 events
                else if(selectedDate.get(Calendar.MONTH) == Calendar.JUNE && selectedDate.get(Calendar.YEAR) == 2025){
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 4) {
                    MonthInfo.setText("June 2025:\n 6/4/25- Last Day of School for Students");
                    }else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                // Check for September 2024 events
               else if (selectedDate.get(Calendar.MONTH) == Calendar.SEPTEMBER && selectedDate.get(Calendar.YEAR) == 2024) {
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 2) {
                        MonthInfo.setText("September 2024:\n9/2/24- Labor Day (NO SCHOOL)");
                    } else if (dayOfMonth == 3) {
                        MonthInfo.setText("September 2024:\n9/3/24- Staff PD (NO SCHOOL)");
                    } else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                // Check for August 2024 events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.AUGUST && selectedDate.get(Calendar.YEAR) == 2024) {
                    if (selectedDate.get(Calendar.DAY_OF_MONTH) == 12) {
                        MonthInfo.setText("August 2024:\n8/12/24- First Day of School!");
                    } else {
                        MonthInfo.setText("No events occurring");
                    }
                }
                //Check for November 2024 events
                else if(selectedDate.get(Calendar.MONTH) == Calendar.NOVEMBER && selectedDate.get(Calendar.YEAR) == 2024){
                  int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                  if (dayOfMonth == 8){
                      MonthInfo.setText("November 2024:\n11/8/24- Staff PD (NO SCHOOL)");
                  }else if(dayOfMonth == 25){
                      MonthInfo.setText("November 2024:\n11/25/24 - 11/29/24- Thanksgiving Break (NO SCHOOL)");
                  }else if(dayOfMonth == 26){
                      MonthInfo.setText("November 2024:\n11/25/24 - 11/29/24- Thanksgiving Break (NO SCHOOL)");
                  }else if(dayOfMonth == 27){
                      MonthInfo.setText("November 2024:\n11/25/24 - 11/29/24- Thanksgiving Break (NO SCHOOL)");
                  }else if(dayOfMonth == 28){
                      MonthInfo.setText("November 2024:\n11/25/24 - 11/29/24- Thanksgiving Break (NO SCHOOL) \n11/28/24- Thanksgiving Day (NO SCHOOL)");
                  }else if(dayOfMonth == 29){
                      MonthInfo.setText("November 2024:\n11/25/24 - 11/29/24- Thanksgiving Break (NO SCHOOL)");
                  }else{
                      MonthInfo.setText("No events occurring");
                  }

                }
                //Check for December 2024 Events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.DECEMBER && selectedDate.get(Calendar.YEAR) == 2024) {
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 23) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 24) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)\n12/24/24- Christmas Eve (NO SCHOOL)");
                    } else if (dayOfMonth == 25) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)\n12/24/24- Christmas Day (NO SCHOOL)");
                    } else if (dayOfMonth == 26) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 27) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 28) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 29) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 30) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)");
                    } else if (dayOfMonth == 31) {
                        MonthInfo.setText("December 2024:\n12/23/24 - 12/31/24- Winter Break (NO SCHOOL)\n12/31/24- New Year's Day (NO SCHOOL)");
                    } else {
                        MonthInfo.setText("No events occurring");
                    }
                }

                // Check for October 2024 events
                else if (selectedDate.get(Calendar.MONTH) == Calendar.OCTOBER && selectedDate.get(Calendar.YEAR) == 2024) {
                    int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
                    if (dayOfMonth == 3) {
                        MonthInfo.setText("October 2024:\n10/3/24- Staff PD (NO SCHOOL)");
                    }else if(dayOfMonth == 4){
                        MonthInfo.setText("October 2024:\n10/4/24- Fall Holiday (NO SCHOOL)");
                    }
                } else {
                        MonthInfo.setText("No events occurring");
                    }


                    getDate();
                }
            });








        /*




        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar laborDay = Calendar.getInstance();
                //  laborDay.set(2024, 9, 3);


                laborDay.set(Calendar.YEAR, 2024);;
                laborDay.set(Calendar.MONTH, 8);
                laborDay.set(Calendar.DAY_OF_MONTH, 3);


                if ((calendar.get(Calendar.YEAR) == laborDay.get(Calendar.YEAR) &&
                        calendar.get(Calendar.DAY_OF_MONTH) == laborDay.get(Calendar.DAY_OF_MONTH))) {


                    MonthInfo.setText("September 2024: "+" 9/2/24- Labor Day (NO SCHOOL)" +  "9/3/24- Staff PD (NO SCHOOL)");
                    System.out.println(calenview.getDate());


                    ;
                }


                else
                if((calendar.get(Calendar.DAY_OF_MONTH)!= laborDay.get(Calendar.DAY_OF_MONTH))) {
                    MonthInfo.setText("No events occuring");
                }
            }


        });
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar Sep2Day = Calendar.getInstance();
                Sep2Day.set(2024, 9, 12);
                if ((calendar.get(Calendar.MONTH) == Sep2Day.get(Calendar.MONTH) &&
                        calendar.get(Calendar.DAY_OF_MONTH) == Sep2Day.get(Calendar.DAY_OF_MONTH))) {


                    MonthInfo.setText("September 2024: "+" 9/2/24- Labor Day (NO SCHOOL)" +  "9/3/24- Staff PD (NO SCHOOL)");


                    ;
                }
                else {
                    if((calendar.get(Calendar.MONTH)!= Sep2Day.get(Calendar.MONTH))){
                        if ((calendar.get(Calendar.DAY_OF_MONTH)!= Sep2Day.get(Calendar.DAY_OF_MONTH))){
                            MonthInfo.setText("No events occuring");
                        }
                    }
                }




            }
        });


        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ButtonClick", "Button clicked"); // Add this line


                // Your existing code for date comparison and text setting goes here
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.setTimeInMillis(calenview.getDate());
                Calendar firstDayOfSchool = Calendar.getInstance();
                firstDayOfSchool.set(2024, Calendar.AUGUST, 12);


                boolean isSameDate = selectedDate.get(Calendar.YEAR) == firstDayOfSchool.get(Calendar.YEAR) &&
                        selectedDate.get(Calendar.MONTH) == firstDayOfSchool.get(Calendar.MONTH) &&
                        selectedDate.get(Calendar.DAY_OF_MONTH) == firstDayOfSchool.get(Calendar.DAY_OF_MONTH);


                Log.d("DateComparison", "Is the selected date the first day of school? " + isSameDate);


                if (isSameDate) {
                    MonthInfo.setText("August 2024:\n8/12/24- First Day of School!");
                } else {
                    MonthInfo.setText("No events occurring");
                }
            }
        });












 laborDay.set(2024, 9, 3);
           if (( calendar.get(Calendar.MONTH) == laborDay.get(Calendar.MONTH) &&
                   calendar.get(Calendar.DAY_OF_MONTH) == laborDay.get(Calendar.DAY_OF_MONTH))) {


               MonthInfo.setText("September 2024: "+" 9/2/24- Labor Day (NO SCHOOL)" +  "9/3/24- Staff PD (NO SCHOOL)");
               System.out.println(calenview.getDate());


               ;
           } else {
               MonthInfo.setText("No events occuring");


           }










DID NOT WORK
  Calendar FIRSTday = Calendar.getInstance();
                //  laborDay.set(2024, 9, 3);


                FIRSTday.set(Calendar.DAY_OF_MONTH, 20);;
                if ((calendar.get(Calendar.DAY_OF_MONTH) == FIRSTday.get(Calendar.DAY_OF_MONTH))) {


               MonthInfo.setText("First Day Of School");
               System.out.println(calenview.getDate());


                    ;
                }


                else
                if((calendar.get(Calendar.DAY_OF_MONTH)!= FIRSTday.get(Calendar.DAY_OF_MONTH))) {
                    MonthInfo.setText("No events occuring");
                }






* */


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

