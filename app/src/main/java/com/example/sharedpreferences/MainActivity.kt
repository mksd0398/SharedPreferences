package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    private lateinit var mEtPreference: EditText
    private lateinit var mBtnReset: Button
    private val NAME: String = "name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()

        if(SharedPreferenceInstance.getStringValue(NAME) != null){
            mEtPreference.setText(SharedPreferenceInstance.getStringValue(NAME))
        }

        mEtPreference.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                SharedPreferenceInstance.setStringValue("$s", NAME)
            }
        })
        mBtnReset.setOnClickListener{
            mEtPreference.setText("")
            SharedPreferenceInstance.clearAll()
        }
    }

    private fun mInitObjects() {
    }

    private fun mInitWidgets() {
        mEtPreference = findViewById(R.id.xEtPlace)
        mBtnReset = findViewById(R.id.xBtnreset)
    }
}