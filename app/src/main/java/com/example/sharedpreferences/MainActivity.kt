package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var mEtPreference: EditText
    private lateinit var mBtnReset: Button
    private var privateMode = 0
    private val prefValue = "truefalse"
    private val prefName = "edittext"
    private lateinit var mSharedPref: SharedPreferenceInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()

        if(mSharedPref.getSomeStringValue(applicationContext) != null){
            mEtPreference.setText(mSharedPref.getSomeStringValue(applicationContext))
        }

        mEtPreference.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mSharedPref.setSomeStringValue(applicationContext,"$s")
            }
        })
        mBtnReset.setOnClickListener{
            mEtPreference.setText("")
            mSharedPref.clear(applicationContext)
        }
    }

    private fun mInitObjects() {
        mSharedPref = SharedPreferenceInstance()
    }

    private fun mInitWidgets() {
        mEtPreference = findViewById(R.id.xEtPlace)
        mBtnReset = findViewById(R.id.xBtnreset)
    }
}