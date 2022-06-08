package com.example.homework1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.example.homework1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
        initWord()
    }
    private fun initListener() {
        binding.btnBack.setOnClickListener {
            val secondTitle = binding.etSecActivity.text.toString()
            if (secondTitle.isNotBlank()) {
                back(secondTitle)
            } else {
                getToast(this, getString(R.string.empty_editText))
            }
        }
    }

    private fun back(secondTitle: String) {
        val intent = Intent()
        intent.putExtra("SendMessage", secondTitle)
        setResult(RESULT_OK, intent)
        finish()
    }
    private fun initWord() {
        val extras: Bundle? = intent.extras
        val title = extras?.getString("main")
        binding.etSecActivity.setText(title)
    }

    private fun getToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}