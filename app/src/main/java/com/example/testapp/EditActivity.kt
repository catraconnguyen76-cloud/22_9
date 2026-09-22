package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "EditActivity: onCreate()")

        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentName = intent.getStringExtra("KEY_NAME") ?: ""
        binding.edtName.setText(currentName)

        binding.btnSave.setOnClickListener {
            val resultIntent = Intent().putExtra("KEY_NAME", binding.edtName.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "EditActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "EditActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "EditActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "EditActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "EditActivity: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "EditActivity: onRestart()")
    }
}
