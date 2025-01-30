package com.udemy08.mycalc

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initListeners()
    }

     private fun initListeners() {
        findViewById<MaterialButton>(R.id.btnAdd).setOnClickListener {
            val firstInput = findViewById<TextInputEditText>(R.id.edtFirstVal)
            val secondInput = findViewById<TextInputEditText>(R.id.edtSecondVal)
            if (TextUtils.isEmpty(firstInput.text)){
                firstInput.error=getString(R.string.str_enter_first_number)
           } else if (TextUtils.isEmpty(secondInput.text)){
                secondInput.error=getString(R.string.str_enter_second_number)
           } else {
                val edtResult = Integer.valueOf(firstInput.text.toString()) + secondInput.text.toString().toInt()
                findViewById<TextView>(R.id.txtRes).text = edtResult.toString()
            }
        }

        findViewById<MaterialButton>(R.id.btnMin).setOnClickListener {
            val firstInput = findViewById<TextInputEditText>(R.id.edtFirstVal)
            val secondInput = findViewById<TextInputEditText>(R.id.edtSecondVal)
            if (TextUtils.isEmpty(firstInput.text)){
                firstInput.error=getString(R.string.str_enter_first_number)
            } else if (TextUtils.isEmpty(secondInput.text)){
                secondInput.error=getString(R.string.str_enter_second_number)
            } else {
                val edtResult = Integer.valueOf(firstInput.text.toString()) - secondInput.text.toString().toInt()
                findViewById<TextView>(R.id.txtRes).text = edtResult.toString()
            }
        }
    }
}