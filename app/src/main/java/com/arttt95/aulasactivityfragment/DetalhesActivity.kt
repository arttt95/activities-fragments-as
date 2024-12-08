package com.arttt95.aulasactivityfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var btnFechar: Button
    private lateinit var textFilme: TextView
    private lateinit var textClassificacao: TextView
    private lateinit var textAvaliacoes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFechar = findViewById(R.id.btn_fechar)
        textFilme = findViewById(R.id.text_filme)
        textClassificacao = findViewById(R.id.text_classificacao)
        textAvaliacoes = findViewById(R.id.text_avaliacoes)

        val bundle = intent.extras // Todos os parâmetros passados -> putExtra()

        if (bundle != null) {
            val filme = bundle.getString("filme")
            val classificacao = bundle.getInt("classificacao")
            val avaliacoes = bundle.getDouble("avaliacoes")

//            val resultado = "Filme: $filme - Clas: $classificacao - Aval: $avaliacoes"

            textFilme.text = "Filme: $filme"
            textClassificacao.text = "Classificação: ${classificacao.toString()}"
            textAvaliacoes.text = "Avaliações: ${avaliacoes.toString()}"
        }

        btnFechar.setOnClickListener {

            finish()

        }

    }
}