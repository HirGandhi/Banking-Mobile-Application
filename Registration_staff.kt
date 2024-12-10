package com.example.assignment_3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registration_staff : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    var gen=""
    lateinit var edt11 : EditText
    lateinit var edt12 : EditText
    lateinit var edt13 : EditText
    lateinit var edt14 : EditText
    lateinit var rg : RadioGroup
    lateinit var rf : RadioButton
    lateinit var rm : RadioButton
    lateinit var sp12: Spinner
    lateinit var btninsert : Button

    fun showToast(text:String)
    {
        Toast.makeText(this@Registration_staff,text,Toast.LENGTH_LONG).show()
    }

    fun clearEdittext()
    {
        edt11.setText("")
        edt12.setText("")
        edt13.setText("")
        edt14.setText("")
        rg.clearCheck()
        sp12.setSelection(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_staff)

        edt11 = findViewById(R.id.edt11)
        edt12 = findViewById(R.id.edt12)
        edt13 = findViewById(R.id.edt13)
        edt14 = findViewById(R.id.edt14)
        sp12 = findViewById(R.id.sp12)
        rg = findViewById(R.id.rg)
        rf = findViewById(R.id.rf)
        rm = findViewById(R.id.rm)
        btninsert = findViewById(R.id.btninsert)

        var branch = arrayOf("--select branch--","Branch 1","Branch 2","Branch 3","Branch 4","Branch 5")
        var arrayAdapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,branch)
        sp12.adapter=arrayAdapter

        btninsert.setOnClickListener {

            try {
                if(rg.checkedRadioButtonId==R.id.rf)
                {
                    gen="female"
                }else{
                    gen="male"
                }
                dbhelper.insertRegister(
                    edt11.text.toString(),
                    edt12.text.toString(),
                    gen,
                    sp12.selectedItem.toString(),
                    edt13.text.toString(),
                    edt14.text.toString()

                )
                clearEdittext()
                showToast("Inserted")
            }catch (e:Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }
}



