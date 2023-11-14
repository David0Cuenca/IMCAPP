package com.pdmd.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var Male: CardView
    private lateinit var Female: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }
    private fun initListeners() {
    val Male:androidx.cardview.widget.CardView = Male
        val Female:androidx.cardview.widget.CardView = Female
        Male.setOnClickListener{
            setGenderColor(Male)
        }
    }
    private fun initComponents() {
        Male = findViewById(R.id.Hombre)
        Female = findViewById(R.id.Mujer)
    }

    private fun setGenderColor(){
        Male.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        Female.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }
    private fun getBackgroundColor(isComponentSelected:Boolean):Int{
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel
        } else {
            R.color.bg_comp
        }
        return ContextCompat.getColor(this,colorReference)
    }
}

