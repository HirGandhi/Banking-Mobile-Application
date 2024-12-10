package com.example.assignment_3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class dbhelper(context: Context) : SQLiteOpenHelper(context,dbname,null,db_version)
{
    companion object{
        private const val db_version = 4
        private const val dbname = "bankdb"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //phonenumber = account number,city = branch ,current balance,dob
        db?.execSQL("create table staffregister(id integer primary key AUTOINCREMENT,name text,pass text,gender text,email text,contactno text,city text)")
        db?.execSQL("create table cust_register1(id integer primary key AUTOINCREMENT,name text,pass text,gender text,email text,contactno text,city text,currbal text,dob String)")
        db?.execSQL("create table trans_cust(id integer primary key AUTOINCREMENT, fromm text, too text, pass text, amount text, date text)")
        //db?.execSQL("create table trans_cust1(id integer primary key AUTOINCREMENT,fromm text,too text,amount integer,dates text,disc text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS staffregister")
        db?.execSQL("DROP TABLE IF EXISTS cust_register1")
        db?.execSQL("DROP TABLE IF EXISTS trans_cust")
        onCreate(db)
    }

    fun insertRegister(name: String,  pass: String, gender: String,city: String,email: String,contactno: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name",name)
        contentValues.put("pass", pass)
        contentValues.put("gender",gender)
        contentValues.put("city",city)
        contentValues.put("email", email)
        contentValues.put("contactno", contactno)

        var result=db.insert("staffregister",null,contentValues)
    }

    fun insertcustomer(name: String,  pass: String, gender: String, city: String ,email: String,contactno: String,currbal :String,dob : String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name",name)
        contentValues.put("pass", pass)
        contentValues.put("gender",gender)
        contentValues.put("city",city)
        contentValues.put("email", email)
        contentValues.put("contactno", contactno)
        contentValues.put("currbal", currbal)
        contentValues.put("dob", dob)
        var result=db.insert("cust_register1",null,contentValues)
    }

    fun inserttransaction(
        fromm : String,
        too: String,
        pass : String,
        amount: String
    ) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("fromm", fromm)
        contentValues.put("too", too)
        contentValues.put("pass", pass)
        contentValues.put("amount",amount)
        var result=db.insert("trans_cust",null,contentValues)
    }

    fun getDatastaff():Cursor    {
        val db = this.readableDatabase
        return db.rawQuery("select * from staffregister",null)
    }

    fun getDatacust():Cursor    {
        val db = this.readableDatabase
        return db.rawQuery("select * from cust_register1",null)
    }

    fun getdatastrans():Cursor    {
        val db = this.readableDatabase
        return db.rawQuery("select * from trans_cust",null)
    }


    fun login_staff(user: String,pass: String): Int {
        val db = this.writableDatabase
        val res = db.rawQuery("SELECT * FROM  staffregister where  name='" + user + "'  and " + "  pass='" + pass +"'", null)
        return res.count
    }

    fun login_cust(user: String,pass: String): Int {
        val db = this.writableDatabase
        val res = db.rawQuery("SELECT * FROM  cust_register1 where  name='" + user + "'  and " + "  pass='" + pass +"'", null)
        return res.count
    }

    fun updatecust(id: Int,name : String,pass: String, gender: String, city: String ,email: String,contactno: String,currbal :String,dob : String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("id", id)
            put("name", name)
            put("pass", pass)
            put("gender", gender)
            put("city", city)
            put("email", email)
            put("contactno", contactno)
            put("currbal", currbal)
            put("dob", dob)
        }
        return db.update("cust_register1", contentValues,"id=?", arrayOf(id.toString()))
    }

    fun updatetrans(id:Int,fromm : String,too: String, amount: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", id)
        contentValues.put("fromm", fromm)
        contentValues.put("too", too)
        contentValues.put("amount",amount)

        return db.update("trans_cust", contentValues,"id=?", arrayOf(id.toString()))
    }

    fun getDatatrans():Cursor {
        val db = this.readableDatabase
        return db.rawQuery("select * from trans_cust",null)
    }


    fun updatestaff(id: Int,name : String,pass: String, gender: String, city: String ,email: String,contactno: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("id", id)
            put("name", name)
            put("pass", pass)
            put("gender", gender)
            put("city", city)
            put("email", email)
            put("contactno", contactno)
        }
        return db.update("staffregister", contentValues,"id=?", arrayOf(id.toString()))
    }

    fun searchaccno(contactno: String):Cursor
    {
        val db=this.readableDatabase
        return db.rawQuery("select * from cust_register1 where contactno=?", arrayOf(contactno))
    }

//    fun searchcitycust(city: String):Int
//    {
//        val db=this.readableDatabase
//        val res = db.rawQuery("select count(*) from cust_register1 where city=?", arrayOf(city))
//        return res.count
//    }
    fun searchcitycust(city: String): Int {
        val db = this.readableDatabase
        val res = db.rawQuery("select count(*) from cust_register1 where city=?", arrayOf(city))
        var count = 0
        if (res.moveToFirst()) {
            count = res.getInt(0) // Get the count from the first column
        }
        res.close() // Don't forget to close the cursor
        return count
    }

    fun searchcitystaff(city: String): Int {
        val db = this.readableDatabase
        val res = db.rawQuery("select count(*) from staffregister where city=?", arrayOf(city))
        var count = 0
        if (res.moveToFirst()) {
            count = res.getInt(0) // Get the count from the first column
        }
        res.close() // Don't forget to close the cursor
        return count
    }
}