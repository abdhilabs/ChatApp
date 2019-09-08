package com.mriksani.chatapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.random.Random

class SignUpActivity : AppCompatActivity() {

    private var userAvatar = "profileDefault"
    private var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        imgAvatar.setOnClickListener {
            changeAvatar()
        }

        btnGenerate.setOnClickListener {
            changeColor()
        }
    }

    private fun changeAvatar() {
        val random = Random
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        userAvatar = if (color == 0) {
            "light$avatar"
        } else {
            "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        imgAvatar.setImageResource(resourceId)
    }

    private fun changeColor() {
        val random = Random
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        imgAvatar.setBackgroundColor(Color.rgb(r, g, b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR,$savedG,$savedB, 1]"

    }
}
