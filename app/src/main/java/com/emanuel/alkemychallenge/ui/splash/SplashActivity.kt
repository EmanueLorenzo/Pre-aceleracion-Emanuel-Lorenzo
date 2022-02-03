package com.emanuel.alkemychallenge.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.res.ResourcesCompat
import com.emanuel.alkemychallenge.R
import com.emanuel.alkemychallenge.ui.MainActivity

@SuppressLint("CustomSplashScreen")
//Splash Screen consiste en una pantalla inicial que muestra el logotipo de la aplicación durante
// uno o varios segundos y que puede o no realizar ciertas operaciones, como, por ejemplo,
// la carga de datos durante ese tiempo, para posteriormente realizar una transición
// hacia la aplicación en sí.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.window.statusBarColor = ResourcesCompat.getColor(resources, R.color.white, null)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 400)
    }
}