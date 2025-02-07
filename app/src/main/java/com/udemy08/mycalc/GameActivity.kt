package com.udemy08.mycalc

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.udemy08.mycalc.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    var binding: ActivityGameBinding? = null
    var randomNumber: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGameBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initListeners()
    }

    private fun initListeners() {
        binding?.apply {
            btnStart.setOnClickListener {
                if (isNotEmptyInput()) {
                    randomNumber = getRandomNumber(
                        edtFirstValue.text.toString().toInt(),
                        edtSecondValue.text.toString().toInt()
                    )

                    inputLayoutGuess.visibility = View.VISIBLE
                    btnGo.visibility = View.VISIBLE
//
                }
            }

            btnGo.setOnClickListener {
                if (TextUtils.isEmpty(edtGuess.text)) {
                    edtGuess.error = getString(R.string.str_enter_number)
                } else {
                    checkGuess(edtGuess.text.toString().toInt())
                }
            }
        }
    }

    private fun getRandomNumber(first: Int, second: Int): Int {
        var min = first
        var max = second

        if (first > second) {
            min = second
            max = first
        }
        return Random.nextInt(max - min + 1) + min
    }

    private fun checkGuess(guess: Int) {
        if (guess == randomNumber) {
            binding?.txtResult?.text = getString(R.string.your_guess_is_correct)
        } else if (randomNumber > guess) {
            binding?.txtResult?.text = getString(R.string.greater_than)
        } else {
            binding?.txtResult?.text = getString(R.string.less_than)
        }
    }

    private fun isNotEmptyInput(): Boolean {
        binding?.apply {
            if (TextUtils.isEmpty(edtFirstValue.text)) {
                edtFirstValue.error = getString(R.string.str_enter_first_number)
            } else if (TextUtils.isEmpty(edtSecondValue.text)) {
                edtSecondValue.error = getString(R.string.str_enter_second_number)
            } else
                return true
        }
        return false
    }
}