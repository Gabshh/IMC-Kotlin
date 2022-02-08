package com.senai.calculadora_imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener(){
            val nome = findViewById<EditText>(R.id.nome).text
            val altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
            val peso = findViewById<EditText>(R.id.peso).text.toString().toInt()
            val resultado = findViewById<TextView>(R.id.resultado)
            val imc = peso / (altura * altura)

            if ( imc < 18.5 ) {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)} \ne você está abaixo do peso."
            } else if ( imc < 25 ) {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está no peso ideal. Parabéns!"
            } else if ( imc < 30 ) {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está levemente acima do peso."
            } else if ( imc < 35 ) {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau I."
            } else if ( imc < 40 ) {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau II."
            } else {
                resultado.text = "$nome Seu imc é ${String.format("%.2f", imc)}  \ne você está com obesidade grau III. Cuidado!"
                resultado.setTextColor(Color.BLACK)
            }
        }

        sair.setOnClickListener(){
            finish()
        }
    }
}