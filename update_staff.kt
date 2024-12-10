package com.example.assignment_3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class update_staff : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    var gen=""
    lateinit var edtid : EditText
    lateinit var edt31 : EditText
    lateinit var edt32 : EditText
    lateinit var edt33 : EditText
    lateinit var edt34 : EditText
    lateinit var rg : RadioGroup
    lateinit var rf : RadioButton
    lateinit var rm : RadioButton
    lateinit var sp12: Spinner
    lateinit var btninsert : Button

    fun showToasts(text:String)
    {
        Toast.makeText(this@update_staff,text, Toast.LENGTH_LONG).show()
    }

    fun clearEdittexts()
    {
        edtid.setText("")
        edt31.setText("")
        edt32.setText("")
        edt33.setText("")
        edt34.setText("")
        rg.clearCheck()
        sp12.setSelection(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_staff)

        edtid = findViewById(R.id.edtid)
        edt31 = findViewById(R.id.edt31)
        edt32 = findViewById(R.id.edt32)
        rg = findViewById(R.id.rg)
        rf = findViewById(R.id.rf)
        rm = findViewById(R.id.rm)
        sp12 = findViewById(R.id.sp12)
        edt33 = findViewById(R.id.edt33)
        edt34 = findViewById(R.id.edt34)
        btninsert = findViewById(R.id.btninsert)

        var branch = arrayOf("--select branch--","Branch 1","Branch 2","Branch 3","Branch 4","Branch 5")
        var arrayAdapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,branch)
        sp12.adapter=arrayAdapter

        btninsert.setOnClickListener {          //update button
            try {
                if(rg.checkedRadioButtonId==R.id.rf)
                {
                    gen="female"
                }else{
                    gen="male"
                }
                val isUpdate = dbhelper.updatestaff(
                    edtid.text.toString().toInt(),
                    edt31.text.toString(),
                    edt32.text.toString(),
                    gen,
                    sp12.selectedItem.toString(),
                    edt33.text.toString(),
                    edt34.text.toString()
                )
                if (isUpdate > 0) {
                    showToasts("Data Updated Successfully");
                    clearEdittexts()
                } else
                    showToasts("Data Not Updated")
            } catch (e: Exception) {
                e.printStackTrace()
                showToasts(e.message.toString())
            }
        }

    }
}