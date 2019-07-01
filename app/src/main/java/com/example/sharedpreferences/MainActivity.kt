package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var mTvDisplay: TextView
    private lateinit var mBtnReset: Button
    private lateinit var mBtnSet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInitWidgets()
        mInitObjects()

        setValue()


        mBtnSet.setOnClickListener{
            storeSharedPreferences()
        }

        mBtnReset.setOnClickListener{
            removeAllPreferences()
        }

    }

    private fun mInitObjects() {
    }

    private fun mInitWidgets() {
        mTvDisplay = findViewById(R.id.xTvDisplay)
        mBtnReset = findViewById(R.id.xBtnreset)
        mBtnSet = findViewById(R.id.xBtnSet)
    }

    private fun storeSharedPreferences(){

        if(SPInstance.getStringValue(getString(R.string.name_pref)) != null){
            setValue()
        }else{
            SPInstance.setStringValue("Mayank" , getString(R.string.name_pref))
            SPInstance.setIntValue(21 , getString(R.string.age_pref))
            SPInstance.setLongValue(80507563728 , getString(R.string.phone_pref))
            setValue()
        }
    }

    private fun removeAllPreferences(){
        SPInstance.clearAll()
        setValue()
    }

    private fun setValue(){
        val name : String?  = SPInstance.getStringValue(getString(R.string.name_pref))
        val age : Int?  = SPInstance.getIntValue(getString(R.string.age_pref))
        val phone : Long? = SPInstance.getLongValue(getString(R.string.phone_pref))
        mTvDisplay.text = "$name \n $age \n $phone"
    }
}