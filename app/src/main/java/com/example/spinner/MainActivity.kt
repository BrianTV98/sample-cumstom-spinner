package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    companion object{
        lateinit var  number :Number
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        number= spinner.selectedItemPosition
        Toast.makeText(this, number.toString(),Toast.LENGTH_SHORT).show()
    }
    var spinnerItems =
        arrayOf("APPLE", "MANGO", "BANANA", "PAPAYA", "WATER MELON")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner =findViewById(R.id.spinner)
        spinner.onItemSelectedListener=this
        // decription
        // Mẫu dữ liệu sẽ được gửi vào 2 cai view : setBackgroud cho title bằng backgroup
        // setbackgroup cho phan noi dung la popupBackgroup :(la ph phan adapter)
        //lay du lieu tu list danh sach
//        val spinnerArrayAdapter = ArrayAdapter(
//            this, R.layout.spinner_textview, spinnerItems
//        )
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_textview)
//
//        spinner.adapter=spinnerArrayAdapter
        // lay du lieu tu resource
        ArrayAdapter.createFromResource(
            this,// context
            R.array.test_array, // du lieu o day
            R.layout.simple_spinner_item // layout title
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_textview) // layout cua item
            spinner.adapter=adapter
        }

    }
}
