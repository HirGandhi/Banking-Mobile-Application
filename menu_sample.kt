package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu_sample : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_sample)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this,"Selected Item : " +item.title, Toast.LENGTH_SHORT).show();
        when(item.itemId){
            R.id.item1-> {intent = Intent(this,listview::class.java)
                          startActivity(intent)
                          };
            R.id.item2-> {intent = Intent(this,transaction_history_display::class.java)
                          startActivity(intent)
                        };
            R.id.item3-> {intent = Intent(this,transfer_money::class.java)
                startActivity(intent)
            };
            R.id.item4-> {intent = Intent(this,update_profile::class.java)
            startActivity(intent)
            };

        }
        return super.onOptionsItemSelected(item)
    }
}