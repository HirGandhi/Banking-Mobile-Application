package com.example.assignment_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class transfer_moneyC : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    lateinit var sp1 : Spinner
    lateinit var edt33 : EditText
    lateinit var edt34 : EditText
    lateinit var btninsert : Button
    lateinit var btnshow : Button

    fun showToastss(text:String)
    {
        Toast.makeText(this@transfer_moneyC,text, Toast.LENGTH_LONG).show()
    }

    fun clearEdittexts()
    {
        sp1.setSelection(0)
        edt34.setText("")


    }

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transfer_money_c)

        sp1 = findViewById(R.id.sp1)
        edt33 = findViewById(R.id.edt33)
        edt34 = findViewById(R.id.edt34)
        btninsert = findViewById(R.id.btninsert)
        btnshow = findViewById(R.id.btnshow)

        //store customer name in arraylist
        val cursor = dbhelper.getDatacust()
        val cust_name = ArrayList<String>()

        if(cursor.moveToFirst())
        {
            do{
                var arr = cursor.getString(cursor.getColumnIndex("name"));
                cust_name.add(arr)
            }while (cursor.moveToNext())
        }
        cursor.close()

        val adapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,cust_name)
        sp1.adapter = adapter


//        btninsert.setOnClickListener {
//            try {
////                dbhelper.inserttransaction(
////                    sp1.selectedItem.toString(),
////                    edt33.text.toString(),
////                    edt34.text.toString()
////                )
//
//                val recipientName = sp1.selectedItem.toString()
//                val enteredPass = edt33.text.toString()
//                val transferAmount = edt34.text.toString().toInt()
//
//                val cursor = dbhelper.getDatacust()
//                if (cursor.moveToFirst()) {
//                    do {
//                        val dbPass = cursor.getString(cursor.getColumnIndex("pass"))
//                        val currentBalance = cursor.getString(cursor.getColumnIndex("currbal")).toInt()
//                        val id = cursor.getInt(cursor.getColumnIndex("id"))
//
//                        if (recipientName == cursor.getString(cursor.getColumnIndex("name"))) {
//                            if (enteredPass == dbPass)
//                            {
//                                if (currentBalance >= transferAmount)
//                                {
//                                    val updatedBalance = currentBalance - transferAmount
//                                    val db = dbhelper.writableDatabase
//                                    db.execSQL("UPDATE cust_register1 SET currbal = ? WHERE id = ?",
//                                        arrayOf(updatedBalance.toString(), id.toString()))
//
//                                    dbhelper.inserttransaction(recipientName, enteredPass,
//                                        transferAmount.toString())
//                                    clearEdittexts()
//                                    showToastss("Transaction successful!")
//                                    } else {
//                                    showToastss("Insufficient balance")
//                                        }
//                                    } else {
//                                showToastss("Invalid transaction password")
//                                }
//                            }
//                        }while (cursor.moveToNext())
//                    }
//
//                clearEdittexts()
//                showToastss("Inserted")
//            }catch (e:Exception){
//                e.printStackTrace()
//                showToastss(e.message.toString())
//            }
//        }
//
//        btnshow.setOnClickListener {
//            intent = Intent(this,trans_show::class.java)
//            startActivity(intent)
//        }

//        btninsert.setOnClickListener {
//            try {
//                val senderName = sp1.selectedItem.toString()
//                val enteredPass = edt33.text.toString()
//                val transferAmount = edt34.text.toString().toInt()
//
//                val cursor = dbhelper.getDatacust()
//                if (cursor.moveToFirst()) {
//                    do {
//                        val dbPass = cursor.getString(cursor.getColumnIndex("pass"))
//                        val currentBalance = cursor.getString(cursor.getColumnIndex("currbal")).toInt()
//                        val id = cursor.getInt(cursor.getColumnIndex("id"))
//
//                        if (senderName == cursor.getString(cursor.getColumnIndex("name"))) {
//                            if (enteredPass == dbPass) {
//                                if (currentBalance >= transferAmount) {
//                                    // Debit from sender
//                                    val updatedBalance = currentBalance - transferAmount
//                                    val db = dbhelper.writableDatabase
//                                    db.execSQL("UPDATE cust_register1 SET currbal = ? WHERE id = ?",
//                                        arrayOf(updatedBalance.toString(), id.toString()))
//
//                                    // Now, credit the recipient
//                                    val recipientCursor = dbhelper.getDatacust()
//                                    if (recipientCursor.moveToFirst()) {
//                                        do {
//                                            val recipientNameDB = recipientCursor.getString(recipientCursor.getColumnIndex("name"))
//                                            if (recipientNameDB == sp1.selectedItem.toString()) {
//                                                val recipientBalance = recipientCursor.getString(recipientCursor.getColumnIndex("currbal")).toInt()
//                                                val updatedRecipientBalance = recipientBalance + transferAmount
//                                                val recipientId = recipientCursor.getInt(recipientCursor.getColumnIndex("id"))
//                                                db.execSQL("UPDATE cust_register1 SET currbal = ? WHERE id = ?",
//                                                    arrayOf(updatedRecipientBalance.toString(), recipientId.toString()))
//                                            }
//                                        } while (recipientCursor.moveToNext())
//                                    }
//                                    recipientCursor.close()
//
//                                    // Insert the transaction
//                                    dbhelper.inserttransaction(senderName, sp1.selectedItem.toString(),
//                                        enteredPass, transferAmount.toString())
//
//                                    clearEdittexts()
//                                    showToastss("Transaction successful!")
//                                } else {
//                                    showToastss("Insufficient balance")
//                                }
//                            } else {
//                                showToastss("Invalid transaction password")
//                            }
//                        }
//                    } while (cursor.moveToNext())
//                }
//
//                cursor.close()
//            } catch (e: Exception) {
//                e.printStackTrace()
//                showToastss(e.message.toString())
//            }
//        }

        btninsert.setOnClickListener {
            try {
                val senderName = "loggedInUser"  // Sender: logged-in user's name
                val recipientName = sp1.selectedItem.toString()  // Recipient selected in spinner
                val enteredPass = edt33.text.toString()
                val transferAmount = edt34.text.toString().toInt()

                // Ensure sender's account data is retrieved correctly
                val cursor = dbhelper.getDatacust()
                if (cursor.moveToFirst()) {
                    do {
                        val dbPass = cursor.getString(cursor.getColumnIndex("pass"))
                        val currentBalance = cursor.getString(cursor.getColumnIndex("currbal")).toInt()
                        val id = cursor.getInt(cursor.getColumnIndex("id"))

                        if (senderName == cursor.getString(cursor.getColumnIndex("name"))) {  // Match sender
                            if (enteredPass == dbPass) {
                                if (currentBalance >= transferAmount) {
                                    // Deduct from sender
                                    val updatedBalance = currentBalance - transferAmount
                                    val db = dbhelper.writableDatabase
                                    db.execSQL(
                                        "UPDATE cust_register1 SET currbal = ? WHERE id = ?",
                                        arrayOf(updatedBalance.toString(), id.toString())
                                    )

                                    // Now credit to recipient account
                                    val recipientCursor = dbhelper.getDatacust()
                                    if (recipientCursor.moveToFirst()) {
                                        do {
                                            val recipientNameDB = recipientCursor.getString(recipientCursor.getColumnIndex("name"))
                                            if (recipientNameDB == recipientName) {  // Match recipient
                                                val recipientBalance = recipientCursor.getString(recipientCursor.getColumnIndex("currbal")).toInt()
                                                val updatedRecipientBalance = recipientBalance + transferAmount
                                                val recipientId = recipientCursor.getInt(recipientCursor.getColumnIndex("id"))
                                                db.execSQL(
                                                    "UPDATE cust_register1 SET currbal = ? WHERE id = ?",
                                                    arrayOf(updatedRecipientBalance.toString(), recipientId.toString())
                                                )
                                            }
                                        } while (recipientCursor.moveToNext())
                                    }
                                    recipientCursor.close()

                                    // Insert transaction into `trans_cust` table
                                    dbhelper.inserttransaction(
                                        senderName,  // Sender name
                                        recipientName,  // Recipient name
                                        enteredPass,
                                        transferAmount.toString()
                                    )

                                    clearEdittexts()
                                    showToastss("Transaction successful!")
                                } else {
                                    showToastss("Insufficient balance")
                                }
                            } else {
                                showToastss("Invalid transaction password")
                            }
                        }
                    } while (cursor.moveToNext())
                }

                cursor.close()
            } catch (e: Exception) {
                e.printStackTrace()
                showToastss(e.message.toString())
            }
        }

    }
}