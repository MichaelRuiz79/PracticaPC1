package com.example.practicapc1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Result_Activity2 : AppCompatActivity() {
    private lateinit var resultadoTextView: TextView
    private lateinit var calificacionTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)

        resultadoTextView = findViewById(R.id.txt_NotaResult)
        calificacionTextView = findViewById(R.id.txt_calificacion)

        val promedio = intent.getDoubleExtra("PROMEDIO",0.0)
        val aprobado = intent.getBooleanExtra("APROBADO",false)
        val promedioFormateado = String.format("%.2f", promedio)

        resultadoTextView.text = "$promedioFormateado"
        calificacionTextView.append("\n" + if (aprobado)"Aprobado" else "Desaprobado")


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun Regresar(view: View) {
        finish()
    }
}