package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }


    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }


    private lateinit var buttonSelected: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    fun clickable(view: View) {
        val buttonSelected = view as Button
        var celld = 0
        when (buttonSelected.id) {

             R.id.imageButton -> celld = 1
            R.id.imageButton2 -> celld = 2
            R.id.imageButton3 -> celld = 3
            R.id.imageButton4 -> celld = 4
            R.id.imageButton5 -> celld = 5
            R.id.imageButton6 -> celld = 6
            R.id.imageButton7 -> celld = 7
            R.id.imageButton8 -> celld = 8
            R.id.imageButton9 -> celld = 9
        }
        // Log.d("Buttun", "$celld ")

        play(celld, buttonSelected)
        winner()
        reSetGame()
    }

    var currentPlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun play(cell: Int, button: Button) {
        if (currentPlayer == 1) {
            button.setBackgroundResource(R.drawable.x)
            player1.add(cell)
            currentPlayer = 2
        } else {
            button.setBackgroundResource(R.drawable.o)
            player2.add(cell)
            currentPlayer = 1
        }
        button.isEnabled = false
    }


    fun winner(){

        var winner=0


        //Raw 1st
        if (player1.contains(1)&& player1.contains(2)&& player1.contains(3)){

              winner=1

        }
        //row second
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1

        }
        //row third
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        //column first
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } //column second
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        //column third
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        //row first
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row second
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row third
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column first
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column second
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column third
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner == 1){
            Toast.makeText(this, "winner is 1", Toast.LENGTH_SHORT).show()
            recreate()
        }

        else if (winner==2)
        {
            Toast.makeText(this, "winner is 2", Toast.LENGTH_SHORT).show()
            recreate()
        }
    }
    fun reSetGame(){
        binding.reSetButton.setOnClickListener {
            recreate()
        }
    }
}
