package com.arttt95.aulasactivityfragment

import android.os.Build
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
    private lateinit var textDescricao: TextView
    private lateinit var textDiretor: TextView
    private lateinit var textDistribuidor: TextView
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
        textDescricao = findViewById(R.id.text_descricao)
        textDiretor = findViewById(R.id.text_diretor)
        textDistribuidor = findViewById(R.id.text_distribuidor)
        textAvaliacoes = findViewById(R.id.text_avaliacoes)

        val bundle = intent.extras // Todos os parâmetros passados -> putExtra()

        if (bundle != null) {

            /*val filme = bundle.getString("filme")
            val classificacao = bundle.getInt("classificacao")
            val avaliacoes = bundle.getDouble("avaliacoes")*/

//            val resultado = "Filme: $filme - Clas: $classificacao - Aval: $avaliacoes"

            val filme = if (Build.VERSION.SDK_INT >= /*33*/ Build.VERSION_CODES.TIRAMISU) { // Verifica a versão que está rodando
//                bundle.getSerializable("filme", Filme::class.java)
                bundle.getParcelable("filme", Filme::class.java)
            } else {
//                bundle.getSerializable("filme") as Filme
                bundle.getParcelable("filme")
            }

//            val filme = bundle.getSerializable("filme") as Filme
//            val filme = bundle.getSerializable("filme", Filme::class.java)

            textFilme.text = "Filme: ${filme?.nome}"
            textDescricao.text = "Descrição: ${filme?.descricao}"
            textDiretor.text = "Diretor: ${filme?.diretor}"
            textDistribuidor.text = "Distribuidor: ${filme?.distribuidor}"
            textAvaliacoes.text = "Avaliações: ${filme?.avaliacoes}"
        }

        btnFechar.setOnClickListener {

            finish()

        }

    }
}