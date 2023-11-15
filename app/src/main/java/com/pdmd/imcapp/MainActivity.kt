package com.pdmd.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var Male: CardView
    private lateinit var Female: CardView
    private lateinit var alturasl: RangeSlider
    private lateinit var textopeso: TextView
    private lateinit var textoedad: TextView
    private lateinit var alturatexto: TextView
    private lateinit var restarpeso: FloatingActionButton
    private lateinit var sumarpeso: FloatingActionButton
    private lateinit var restaredad: FloatingActionButton
    private lateinit var sumaredad: FloatingActionButton
    private var peso:Int = 60
    private var edad:Int= 18
    private lateinit var calcular: AppCompatButton
    var isMaleSelected: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
        initUI()
    }
    private fun initComponents() {
        Male = findViewById(R.id.Hombre)
        Female = findViewById(R.id.Mujer)
        alturasl = findViewById(R.id.rsHeight)
        alturatexto = findViewById(R.id.tvHeight)
        textoedad=findViewById(R.id.edad)
        restarpeso=findViewById(R.id.quitarpeso)
        textopeso=findViewById(R.id.peso)
        sumarpeso=findViewById(R.id.ayadirpeso)
        restaredad=findViewById(R.id.quitarpeso)
        sumaredad=findViewById(R.id.ayadirpeso)
        calcular=findViewById(R.id.calcular)
    }
    private fun initUI(){
        setGenderColor()
        setAge()
        setWeight()
    }
    private fun initListeners() {
        var select:Boolean
        Male.setOnClickListener{
            isMaleSelected=true
            setGenderColor()
        }
        Female.setOnClickListener{
            isMaleSelected=false
            setGenderColor()
        }
        alturasl.addOnChangeListener { _ , value, _ ->
            //tvHeight.text = value.toString()
            alturatexto.text = DecimalFormat("#.##").format(value) + " cm"
        }
        restarpeso.setOnClickListener{
            peso -=1
            setWeight()
        }
        sumarpeso.setOnClickListener{
            peso +=1
            setWeight()
        }

        restaredad.setOnClickListener{
            edad -= 1
            setAge()
        }

        sumaredad.setOnClickListener{
            edad += 1
            setAge()
        }
        calcular.setOnClickListener {
            navigate2result(calculateIMC())
        }
    }

    private fun setGenderColor() {
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

    private fun setWeight(){
        textopeso.setText(peso)
    }

    private fun setAge(){
        textoedad.setText(edad)
    }

    private fun calculateIMC():Double{
        var pesodoble:Double= peso.toDouble()
        var alturadoble:Double = alturatexto.toString().toDouble() * 2
        var resultado:Double= (pesodoble/alturadoble) * 0.01
        return resultado
    }

    private fun navigate2result(IMC:Double){
        val intentResultado = Intent(this,ImcResultActivity::class.java)
        intentResultado.putExtra("result",IMC)
        startActivity(intentResultado)
    }


}


