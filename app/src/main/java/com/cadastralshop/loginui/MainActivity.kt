package com.cadastralshop.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = etUsername.text
        val password = etPassword.text

        btnLogin.setOnClickListener {
            if (username.isEmpty() || password.isEmpty()) {
                snackbarInfo(it, "Anda Belum Melengkapi Nama Pengguna atau Kata Kunci!")
            } else if (username.trim()
                    .toString() == "kitacuci" && password.toString() == "123456"
            ) {
                val Dashboard = Intent(this, Dashboard::class.java)
                startActivity(Dashboard)
                finish()
            } else {
                snackbarInfo(it, "Nama Pengguna atau Password Belum Tepat")
            }
        }

    }

    fun snackbarInfo(it: View, textinfo: String) {
        Snackbar.make(it, textinfo, Snackbar.LENGTH_LONG).show()
    }
}
