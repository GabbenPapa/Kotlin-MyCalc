package com.udemy08.mycalc

import android.annotation.SuppressLint
import android.app.Activity
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
import com.udemy08.mycalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()
    }

    private fun initListeners() {
        binding?.apply {
            btnAdd.setOnClickListener {
                if (TextUtils.isEmpty(edtFirstVal.text)) {
                    edtFirstVal.error = getString(R.string.str_enter_first_number)
                } else if (TextUtils.isEmpty(edtSecondVal.text)) {
                    edtSecondVal.error = getString(R.string.str_enter_second_number)
                } else {
                    val edtResult =
                        Integer.valueOf(edtFirstVal.text.toString()) + edtSecondVal.text.toString().toInt()
                    txtRes.text = edtResult.toString()
                }
            }

            btnMin.setOnClickListener {
                if (TextUtils.isEmpty(edtFirstVal.text)) {
                    edtFirstVal.error = getString(R.string.str_enter_first_number)
                } else if (TextUtils.isEmpty(edtSecondVal.text)) {
                    edtSecondVal.error = getString(R.string.str_enter_second_number)
                } else {
                    val edtResult =
                        Integer.valueOf(edtFirstVal.text.toString()) - edtSecondVal.text.toString().toInt()
                    txtRes.text = edtResult.toString()
                }
            }

            btnMulti.setOnClickListener {
                if (TextUtils.isEmpty(edtFirstVal.text)) {
                    edtFirstVal.error = getString(R.string.str_enter_first_number)
                } else if (TextUtils.isEmpty(edtSecondVal.text)) {
                    edtSecondVal.error = getString(R.string.str_enter_second_number)
                } else {
                    val edtResult = 
                        Integer.valueOf(edtFirstVal.text.toString()) * edtSecondVal.text.toString().toInt()
                    txtRes.text = edtResult.toString()
                }
            }

            btnDiv.setOnClickListener {
                if (TextUtils.isEmpty(edtFirstVal.text)) {
                    edtFirstVal.error = getString(R.string.str_enter_first_number)
                } else if (TextUtils.isEmpty(edtSecondVal.text)) {
                    edtSecondVal.error = getString(R.string.str_enter_second_number)
                } else {
                    val edtResult =
                        Integer.valueOf(edtFirstVal.text.toString()) / edtSecondVal.text.toString().toInt()
                    txtRes.text = edtResult.toString()
                }
            }
        }
    }
}