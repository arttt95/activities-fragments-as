package com.arttt95.aulasactivityfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("ciclo_vida", "onCreate")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAbrir = findViewById(R.id.btn_abrir)

        btnAbrir.setOnClickListener {

            var intent = Intent(this, DetalhesActivity::class.java)

            // Passar parameters para a próxima activity
            intent.putExtra("filme", "The Witcher")
            intent.putExtra("classificacao", 5)
            intent.putExtra("avaliacoes", 9.2)

            startActivity(intent)

        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "onStart")
        // Carregar dados
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {

        Log.i("ciclo_vida", "onDestroy")
        super.onDestroy()

    }

}