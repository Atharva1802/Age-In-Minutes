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
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)}


    }
    fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedyear, selectedmonth, selecteddayOfMonth ->
                Toast.makeText(this,
                        "The chosen year is $selectedyear and month is $selectedmonth and Day is $selecteddayOfMonth",
                        Toast.LENGTH_LONG).show()
                val selectedDate = "$selecteddayOfMonth/${selectedmonth + 1} / $selectedyear"
                tvSelectedDate.text = selectedDate
            },
            year,
            month,
            day,
        ).show()

    }
}