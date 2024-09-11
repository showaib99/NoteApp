package com.example.noteapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("NoteApp", Context.MODE_PRIVATE)

        binding.saveBtn.setOnClickListener{
            val note = binding.noteEt.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("note", note)
            editor.apply()

            Toast.makeText(this,"Note is added successfully!", Toast.LENGTH_SHORT).show()
            binding.noteEt.text.clear()

        }

        binding.displayNote.setOnClickListener{
            val note = sharedPreferences.getString("note", "")
            binding.noteTV.text = "$note"
        }
    }


}