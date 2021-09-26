package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_row.*

class MainActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var myText: EditText
    lateinit var cl: ConstraintLayout
    private val myList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.button2)
        myText = findViewById(R.id.edText)
        cl= findViewById(R.id.clMAin)
        val myRV = findViewById<RecyclerView>(R.id.rvMain)

        myRV.adapter = RecyclerViewAdapter(myList)
        myRV.layoutManager = LinearLayoutManager(this)
        myButton.setOnClickListener { myFunction() }
    }

    private fun myFunction(){

        var dailyTask = myText.text.toString()
        if (dailyTask.isEmpty()){
            Snackbar.make(cl, "Please Enter Your Task" , Snackbar.LENGTH_LONG).show()
        }else {
            myList.add(dailyTask)
        }
    }
}