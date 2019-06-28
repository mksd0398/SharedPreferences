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
    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()

        if(mSharedPref.getBoolean(prefValue , false)){
            Log.i("preference value", mSharedPref.getString(prefName,"").toString())
            mEtPreference.setText(mSharedPref.getString(prefName,""))
        }

        mEtPreference.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val editor = mSharedPref.edit()
                editor.putBoolean(prefValue, true)
                editor.putString(prefName, "$s")
                editor.apply()
            }
        })
        mBtnReset.setOnClickListener{
            mEtPreference.setText("")
            mSharedPref.edit().clear().apply()
        }
    }

    private fun mInitObjects() {
        mSharedPref = getSharedPreferences(prefName , privateMode)
    }

    private fun mInitWidgets() {
        mEtPreference = findViewById(R.id.xEtPlace)
        mBtnReset = findViewById(R.id.xBtnreset)
    }
}