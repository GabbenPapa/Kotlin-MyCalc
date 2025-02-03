package com.udemy08.mycalc

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    
    @SuppressLint("SetTextI18n")
    private fun initListeners() {
        binding?.apply {
            btnAdd.setOnClickListener {
                if (isNotEmptyInput()) {
                    txtRes.text = sumNumbers(
                        edtFirstVal.text.toString().toInt(),
                        edtSecondVal.text.toString().toInt()
                    ).toString()
                }
            }

            btnMin.setOnClickListener {
                if (isNotEmptyInput()) {
                    txtRes.text = minNumbers(
                        edtFirstVal.text.toString().toInt(),
                        edtSecondVal.text.toString().toInt()
                    ).toString()
                }
            }

            btnMulti.setOnClickListener {
                if (isNotEmptyInput()) {
                    txtRes.text = multiplyNumbers(
                        edtFirstVal.text.toString().toInt(),
                        edtSecondVal.text.toString().toInt()
                    ).toString()
                }
            }

            btnDiv.setOnClickListener {
                if (isNotEmptyInput()) {
                    txtRes.text = divNumbers(
                        edtFirstVal.text.toString().toInt(),
                        edtSecondVal.text.toString().toInt()
                    ).toString()
                }
            }
        }
    }

    private fun isNotEmptyInput(): Boolean {
        binding?.apply {
            if (TextUtils.isEmpty(edtFirstVal.text)) {
                edtFirstVal.error = getString(R.string.str_enter_first_number)
            } else if (TextUtils.isEmpty(edtSecondVal.text)) {
                edtSecondVal.error = getString(R.string.str_enter_second_number)
            } else
                return true
        }
        return false
    }

    private fun sumNumbers(firstInput: Int, secondInput: Int): Int {
        return firstInput + secondInput
    }

    private fun minNumbers(firstInput: Int, secondInput: Int): Int {
        return firstInput - secondInput
    }

    private fun multiplyNumbers(firstInput: Int, secondInput: Int): Int {
        return firstInput * secondInput
    }

    private fun divNumbers(firstInput: Int, secondInput: Int): Float {
        return firstInput.toFloat() / secondInput.toFloat()
    }
}