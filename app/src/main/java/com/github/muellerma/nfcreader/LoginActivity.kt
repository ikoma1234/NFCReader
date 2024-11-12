package com.github.muellerma.nfcreader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var passwordField: TextView
    private lateinit var messageText: TextView

    // パスワードを "1234" として仮定
    private val correctPassword = "1234"
    private var inputPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        passwordField = findViewById(R.id.passwordField)
        messageText = findViewById(R.id.messageText)
        val enterButton: Button = findViewById(R.id.enterButton)

        // 0〜9のテンキーのボタンを設定
        val numberButtons = listOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )

        // テンキー押下時の処理
        for (i in numberButtons.indices) {
            numberButtons[i].setOnClickListener {
                if (inputPassword.length < 4) {
                    inputPassword += i.toString()
                    passwordField.text = inputPassword
                }
            }
        }

        // 入力ボタン押下時の処理
        enterButton.setOnClickListener {
            if (inputPassword == correctPassword) {
                // パスワードが正しければMainActivityに遷移
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // パスワードが間違っていればメッセージを変更
                messageText.text = "パスワードが違うぞ！"
                inputPassword = ""
                passwordField.text = ""
            }
        }
    }
}
