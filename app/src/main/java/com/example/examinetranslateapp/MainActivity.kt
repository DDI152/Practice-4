package com.example.examinetranslateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examinetranslateapp.databinding.ActivityMainBinding
import java.util.*


 class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btTranslate.setOnClickListener {
            val countryMy = Locale.getDefault().language.lowercase()
            val text = binding.editText.getText().toString()
            val translateAPI = TranslateAPI(Language.AUTO_DETECT, countryMy, text)
            translateAPI.setTranslateListener(object : TranslateAPI.TranslateListener {
                override fun onSuccess(translatedText: String?) {
                    binding.textView.text = translatedText
                }
                override fun onFailure(ErrorText: String?) {
                    Log.d("MyLog", "Error of translate!")
                }
            })
        }
    }
}