package com.pdmd.imcapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

class ImcResultActivity(defaultValue: Double) : AppCompatActivity() {
    private lateinit var nResultado: TextView
    private lateinit var dResultado: TextView
    private lateinit var descipcion: TextView
    private lateinit var recalcular: AppCompatButton
    private var dtexto:String= "xxx"
    private var nnumero:Double= intent.getDoubleExtra("result",defaultValue)
    private var descripcionFinal = "Lorem Impus"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        initListeners()
        initUI()
    }

    private fun initListeners() {
        recalcular.setOnClickListener{
            startMain()
        }
    }
    private fun initUI() {
        setTextResult()
        SetStatus()
    }

    private fun initComponents(){
        dResultado = findViewById(R.id.dresultado)
        nResultado = findViewById(R.id.nresultado)
        descipcion = findViewById(R.id.descripcion)
    }
    private fun startMain(){
        val principal = Intent(this,MainActivity::class.java)
        startActivity(principal)
    }

    private fun SetStatus(){
        if(nnumero<18.5){
            dtexto = getString(R.string.gradouno_titulo)
            descripcionFinal = getString(R.string.gradouno_des)
        }else if(nnumero<24.9){
            dtexto = getString(R.string.gradodos_titulo)
            descripcionFinal = getString(R.string.gradodos_des)
        }else if(nnumero<29.9){
            dtexto = getString(R.string.gradotres_titulo)
            descripcionFinal = getString(R.string.gradotres_des)
        }else{
            dtexto = getString(R.string.gradocuatro_titulo)
            descripcionFinal = getString(R.string.gradocuatro_des)
        }
    }
    private fun setTextResult(){
        dResultado.setText(dtexto)
        descipcion.setText(descripcionFinal)
    }
}