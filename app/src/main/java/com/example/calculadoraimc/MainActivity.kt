package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var btnCalcular:Button
    lateinit var editPeso:EditText
    lateinit var editAltura:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupData()
        setupListener()

    }


    fun setupData(){
        btnCalcular = findViewById(R.id.btn_calcular)
        editPeso = findViewById(R.id.edit_peso)
        editAltura = findViewById(R.id.edit_altura)
    }

    fun setupListener(){
        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)
            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            if(peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso",peso.toDouble())
                intent.putExtra("altura",altura.toDouble())
            }

            startActivity(intent);
        }
    }

}