package com.foysal.practice.hrm.View

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.foysal.practice.hrm.R
import es.dmoral.toasty.Toasty
import java.util.*

class ExceptionEntryActivity : AppCompatActivity() {

    lateinit var editName: EditText
    lateinit var editId: EditText
    lateinit var editType: AutoCompleteTextView
    lateinit var editReason: EditText
    lateinit var btnApply: Button
    lateinit var calendar: Calendar
    lateinit var editDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exception_entry)

        supportActionBar?.title = "Exception Entry"

        editDate = findViewById(R.id.ee_date)
        editName = findViewById(R.id.ee_name)
        editId = findViewById(R.id.ee_id)
        editReason = findViewById(R.id.ee_reason)
        btnApply = findViewById(R.id.ee_apply)
        editType = findViewById(R.id.ee_drop__down)

        val types = resources.getStringArray(R.array.all_types)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_menu, types)

        val autoCompleteTypes = findViewById<AutoCompleteTextView>(R.id.ee_drop__down)

        autoCompleteTypes.setAdapter(arrayAdapter)



        val name = editName.text.toString()
        val id = editId.text.toString()
        val type:String = editType.text.toString()
        val date = editDate.text.toString()
        val reason = editReason.text.toString()

        editDate.setOnClickListener{

            calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    editDate.setText(dat)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.datePicker.setMaxDate(Date().time - 36400000)
            datePickerDialog.show()

            /*Log.i("date", "${autodate.text}")*/

        }

        btnApply.setOnClickListener {


            ExceptionDetails.setException(name,id, date, type, reason)
            Toasty.success(this, "Application Success", Toast.LENGTH_SHORT).show()
        }

        Log.i("date", "${ExceptionDetails.getException().size}")


    }


    }
}