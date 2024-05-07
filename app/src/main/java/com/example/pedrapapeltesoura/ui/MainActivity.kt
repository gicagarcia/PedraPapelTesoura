package com.example.pedrapapeltesoura.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pedrapapeltesoura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.btnTwoPlayers.setOnClickListener{
            play1v1()
        }

        amb.btnThreePlayers.setOnClickListener{
            play1v2()
        }
    }

    private fun play1v1(){
        val intent = Intent(this@MainActivity, PlayTwoActivity::class.java)
        startActivity(intent)
    }

    private fun play1v2(){
        val intent = Intent(this@MainActivity, PlayThreeActivity::class.java)
        startActivity(intent)
    }
}