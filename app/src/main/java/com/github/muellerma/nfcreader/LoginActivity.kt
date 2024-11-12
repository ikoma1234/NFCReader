package com.github.muellerma.nfcreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val password = editTextPassword.text.toString()
            if (password == "1234") {
                // ログイン成功
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // ログイン失敗
                // TODO: ログイン失敗時の処理 (エラー表示など)
            }
        }
    }
}