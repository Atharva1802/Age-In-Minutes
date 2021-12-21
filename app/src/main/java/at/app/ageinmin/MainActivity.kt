package at.app.ageinmin

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)}


    }
    fun clickDatePicker(view: View) {           // Intialized function for main activity
        val myCalender = Calendar.getInstance() // .getInstace imports object calendar from class Calendar
        val year = myCalender.get(Calendar.YEAR) // Further get(Calendar.xxxx) used
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
       val dpd =  DatePickerDialog(     // For Calendar     //A dialog is a small window that prompts the user
                                                  // to make a decision or enter additional information.
            this,
            DatePickerDialog.OnDateSetListener {  // To show this Dialogue when DatePicker is clicked
                    view, selectedYear, selectedMonth, selectedDayOfMonth -> //prompting a view


                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1} / $selectedYear" // String
                tvSelectedDate.text = selectedDate      // Feed in Text View tvSelectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy") /* From class SimpleDateFormat */

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes = currentDate!!.time / 60000
                val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
                tvSelectedDateInMinutes.text = differenceInMinutes.toString()
            }
            ,year
            ,month
            ,day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}