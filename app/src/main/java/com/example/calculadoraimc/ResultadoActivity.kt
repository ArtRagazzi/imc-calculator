package com.example.calculadoraimc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ResultadoActivity : AppCompatActivity() {

    lateinit var textPeso:TextView
    lateinit var textAltura:TextView
    lateinit var textResultado:TextView
    lateinit var btnVoltar:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupData()
        setBundle()


    }


    fun setupData(){
        textPeso = findViewById(R.id.tv_peso_informado)
        textAltura = findViewById(R.id.tv_altura_informada)
        textResultado = findViewById(R.id.tv_resultado)
        btnVoltar = findViewById(R.id.btn_voltar)
    }

    fun setBundle(){
        val bundle = intent.extras
        if(bundle!=null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")
            textPeso.text = "Peso informado: $peso kg"
            textAltura.text = "Altura informada: $altura m"
            textResultado.text = "${caculateImc(peso, altura)}"
            btnVoltar.visibility = View.VISIBLE
            setupListener()

        }
    }

    fun caculateImc(peso:Double, altura:Double):String{
        val imc = peso / (altura * altura)

        if(imc > 30.0){
            return "Obsidade"
        }
        else if (imc > 25){
            return "Sobrepeso"
        }
        else if(imc > 18.5){
            return "Normal"
        }
        else if(imc < 18.5){
            return "Baixo"
        }
        else{
            return "Invalido"
        }
    }

    fun setupListener(){
        btnVoltar.setOnClickListener {
            finish()
        }
    }

}