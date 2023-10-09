package com.example.timepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private var day=0
    var month=0
    var year=0
    var hour=0
    var minute=0

    var savedDay =0
    var savedMonth=0
    var savedYear =0
    var savedHour =0
    var savedMinute =0

    // get reference to button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Diclear the button in onclicklistenar

        val btn1 = findViewById(R.id.btn1) as Button

        btn1.setOnClickListener(){
            pickDate()
        }

    }


    private fun getDateTimeCalendra(){
        val cal = Calendar.getInstance()
        day =cal.get(Calendar.DAY_OF_MONTH)
        day =cal.get(Calendar.MONTH)
        day =cal.get(Calendar.YEAR)
        day =cal.get(Calendar.HOUR)
        day =cal.get(Calendar.MINUTE)
    }
    private fun pickDate(){
        getDateTimeCalendra()
        DatePickerDialog(this, this, year,month,day).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendra()

        TimePickerDialog(this, this,hour,minute,true).show()
    }


 @SuppressLint
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour =hourOfDay
     savedMinute = minute

      "$savedDay-$savedMonth-$savedYear\n Hour:$savedHour Minute: $savedMinute"

    }
}