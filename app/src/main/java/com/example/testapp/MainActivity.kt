package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newName = result.data?.getStringExtra("KEY_NAME") ?: ""
            binding.tvProfileName.text = getString(R.string.profile_name_format, newName)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "MainActivity: onCreate()")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val savedName = savedInstanceState.getString("KEY_SAVED_NAME")
            if (!savedName.isNullOrEmpty()) {
                binding.tvProfileName.text = savedName
            }
        }

        binding.btnEdit.setOnClickListener {
            val currentText = binding.tvProfileName.text.toString()
            val rawName = currentText.removePrefix("Họ tên: ")
            val nameToPass = if (rawName == "Chưa có thông tin") "" else rawName

            val intent = Intent(this, EditActivity::class.java).apply {
                putExtra("KEY_NAME", nameToPass)
            }
            editLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("KEY_SAVED_NAME", binding.tvProfileName.text.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "MainActivity: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "MainActivity: onRestart()")
    }
}
