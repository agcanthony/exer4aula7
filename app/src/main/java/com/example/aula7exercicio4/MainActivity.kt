package com.example.aula7exercicio4

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nestedScrollView = findViewById<View>(R.id.nestedScrollView)
        val fadeInOutView = findViewById<View>(R.id.fadeInOutView)

        nestedScrollView.viewTreeObserver.addOnScrollChangedListener {
            // Obtém a posição de rolagem vertical
            val scrollY = nestedScrollView.scrollY
            // Obtém a altura da view fadeInOutView
            val viewHeight = fadeInOutView.height.toFloat()
            // Calcula o fator de escala com base na posição de rolagem
            val scale = 1 - scrollY / viewHeight

            // Adiciona uma animação de fade-in/fade-out à view fadeInOutView
            // Utiliza ObjectAnimator para ajustar a propriedade alpha (transparência)
            ObjectAnimator.ofFloat(fadeInOutView, "alpha", scale).apply {
                duration = 0 // Define a duração da animação em milissegundos
                start()
            }

            // Verifica se o usuário chegou ao final do scroll (baseado no seu layout)
            if (scrollY + nestedScrollView.height == nestedScrollView.getChildAt(0).height) {
                // Adiciona um Toast para indicar que o usuário chegou ao final
                Toast.makeText(this, "Final do scroll atingido!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

private fun View.getChildAt(i: Int): Any {

}
