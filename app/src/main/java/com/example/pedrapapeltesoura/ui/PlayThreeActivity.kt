package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.GameForThreeBinding
import com.example.pedrapapeltesoura.plays.Plays

class PlayThreeActivity : AppCompatActivity() {
    private val p3b: GameForThreeBinding by lazy {
        GameForThreeBinding.inflate(layoutInflater)
    }
    private var play: Plays? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(p3b.root)
        playVsBots()
    }

    private fun playVsBots(){
        setPlay()
        p3b.btnChoose.setOnClickListener{
            val bot1 = Plays.entries.random()
            val bot2 = Plays.entries.random()
            val botPlays: List<Plays> = listOf(bot1, bot2)
            battle(play, botPlays)
        }

    }

    private fun battle(play: Plays?, bots: List<Plays>) {
        val message: String
        var userWins = 0
        var botWins = 0
        var draws = 0

        for (bot in bots) {
            when {
                play == bot -> draws++
                play == Plays.PEDRA && bot == Plays.TESOURA ||
                        play == Plays.PEDRA && bot == Plays.LAGARTO ||
                        play == Plays.PAPEL && bot == Plays.PEDRA ||
                        play == Plays.PAPEL && bot == Plays.SPOCK ||
                        play == Plays.TESOURA && bot == Plays.PAPEL ||
                        play == Plays.TESOURA && bot == Plays.LAGARTO ||
                        play == Plays.LAGARTO && bot == Plays.PAPEL ||
                        play == Plays.LAGARTO && bot == Plays.SPOCK ||
                        play == Plays.SPOCK && bot == Plays.PEDRA ||
                        play == Plays.SPOCK && bot == Plays.TESOURA -> userWins++
                else -> botWins++
            }
        }

        message = when {
            userWins > botWins -> "VITÓRIA"
            userWins < botWins -> "DERROTA"
            else -> "EMPATE"
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    private fun setPlay() {
        p3b.pedra.setOnClickListener{
            play = Plays.PEDRA
        }

        p3b.tesoura.setOnClickListener{
            play = Plays.TESOURA
        }

        p3b.papel.setOnClickListener{
            play = Plays.PAPEL
        }
        p3b.lizard.setOnClickListener{
            play = Plays.LAGARTO
        }
        p3b.spock.setOnClickListener{
            play = Plays.SPOCK
        }
    }

}
