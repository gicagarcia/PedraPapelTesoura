package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.pedrapapeltesoura.databinding.GameForTwoBinding
import com.example.pedrapapeltesoura.plays.Plays

class PlayTwoActivity : AppCompatActivity(){
    private val p2b: GameForTwoBinding by lazy {
        GameForTwoBinding.inflate(layoutInflater)
    }
    private var play: Plays? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(p2b.root)
        playVsBot()
    }

    private fun playVsBot(){
        setPlay()
        p2b.btnChoose.setOnClickListener{
            val bot = Plays.entries.random()
            battle(play, bot)
        }

    }

    private fun battle(play: Plays?, bot: Plays) {
        val message: String
        when {
            play == bot -> message = "EMPATE - O bot escolheu $bot"
            play == Plays.PEDRA && bot == Plays.TESOURA ||
                    play == Plays.PEDRA && bot == Plays.LAGARTO ||
                    play == Plays.PAPEL && bot == Plays.PEDRA ||
                    play == Plays.PAPEL && bot == Plays.SPOCK ||
                    play == Plays.TESOURA && bot == Plays.PAPEL ||
                    play == Plays.TESOURA && bot == Plays.LAGARTO ||
                    play == Plays.LAGARTO && bot == Plays.PAPEL ||
                    play == Plays.LAGARTO && bot == Plays.SPOCK ||
                    play == Plays.SPOCK && bot == Plays.PEDRA ||
                    play == Plays.SPOCK && bot == Plays.TESOURA -> message = "VITÓRIA - O bot escolheu $bot"
            else -> message = "DERROTA - O bot escolheu $bot"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun setPlay() {
        p2b.pedra.setOnClickListener{
            play = Plays.PEDRA
        }

        p2b.tesoura.setOnClickListener{
            play = Plays.TESOURA
        }

        p2b.papel.setOnClickListener{
            play = Plays.PAPEL
        }
        p2b.lizard.setOnClickListener{
            play = Plays.LAGARTO
        }
        p2b.spock.setOnClickListener{
            play = Plays.SPOCK
        }
    }
}
