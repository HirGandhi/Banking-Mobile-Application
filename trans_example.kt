package com.example.assignment_3

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class trans_example : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trans_example)

//        var usr_id = intent.getIntExtra("user_id",0)
//
//        var spnr : Spinner = findViewById(R.id.spinner_transec_page)
//        var rupee : EditText = findViewById(R.id.rupees_transect_page)
//        var transection_pass : EditText = findViewById(R.id.code_transect_page)
//        var doTransection : Button = findViewById(R.id.button_trans_page)
//        var receiverCus : String = ""
//
//        var db = dbhelper(this)
//        var ob1 = db.getDatacust()
//
//        var ar = db.getDatacust()
//        var adptr = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ar)
//        spnr.adapter = adptr
//
//        spnr.onItemSelectedListener = object : OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                if (position >= 0 && position < ar.size)
//                {
//                    receiverCus = ar[position]
//                    Toast.makeText(this@trans_example,receiverCus, Toast.LENGTH_SHORT).show()
//                }
//                else
//                    Toast.makeText(this@trans_example, "Invalid selection", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//        }
//
//
//        doTransection.setOnClickListener{
//            if(ob1.transection_code == transection_pass.text.toString())
//            {
//                var ob = tran()
//                ob.cus_id = usr_id
//                ob.branch_name = ob1.branch_name
//                ob.sender = ob1.usernm
//                ob.receiver = receiverCus
//                ob.amount = Integer.parseInt(rupee.text.toString())
//                val flg = db.insert_transections_data(ob)
//                try {
//                    if(flg)
//                    {
//                        try {
//                            val flg1 = db.update_customer_balance(ob1.usernm,Integer.parseInt(rupee.text.toString()),"-") // Debit money
//                            if(flg1)
//                                Toast.makeText(this@trans_example,"Money debited from sender",
//                                    Toast.LENGTH_SHORT).show()
//                        }catch (e1 : Exception)
//                        {
//                            Toast.makeText(this,e1.message.toString(), Toast.LENGTH_LONG).show()
//                        }
//
//                        try {
//                            val flg2 = db.update_customer_balance(receiverCus,Integer.parseInt(rupee.text.toString()),"+")
//                            if(flg2)
//                                Toast.makeText(this@trans_example,"Money credited to receiver",
//                                    Toast.LENGTH_SHORT).show()
//                        }catch (e2 : Exception)
//                        {
//                            Toast.makeText(this,e2.message.toString(), Toast.LENGTH_LONG).show()
//                        }
//                    }
//                    else
//                        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
//                }
//                catch (e : Exception)
//                {
//                    Toast.makeText(this,e.message.toString(), Toast.LENGTH_LONG).show()
//                }
//
//            }
//            else
//                Toast.makeText(this,"Invalid transection password", Toast.LENGTH_LONG).show()
//        }
    }
}