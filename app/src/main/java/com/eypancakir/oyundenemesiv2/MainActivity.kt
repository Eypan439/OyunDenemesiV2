package com.eypancakir.oyundenemesiv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun main() {
        val board = Board()

        val players = listOf(
            Player("Player 1", "RED"),
            Player("Player 2", "GREEN"),
            Player("Player 3", "BLUE"),
            Player("Player 4", "YELLOW")
        )

        var currentPlayerIndex = 0

        while (players.size > 1) {
            val currentPlayer = players[currentPlayerIndex]
            println("It's ${currentPlayer.name}'s turn")

            board.printBoard()
            println("Select a block to remove (1-10):")
            val selectedBlockIndex = readLine()?.toIntOrNull()?.minus(1)

            if (selectedBlockIndex != null && selectedBlockIndex in 0..9) {
                val selectedBlock = currentPlayer.getBlock(selectedBlockIndex)
                board.removeBlock(selectedBlock)
                currentPlayer.removeBlock(selectedBlock)

                val random = (0..1).random()
                if (random == 1) {
                    val nextPlayerIndex = (currentPlayerIndex + 1) % players.size
                    val nextPlayer = players[nextPlayerIndex]
                    nextPlayer.blocks.add(selectedBlock)
                    selectedBlock.setColor(nextPlayer.color)
                    selectedBlock.setOwner(nextPlayer)
                    println("${currentPlayer.name} lost the block!")
                    println("${nextPlayer.name} gained the block!")
                } else {
                    println("${currentPlayer.name} won the block!")
                }

                if (currentPlayer.blocks.isEmpty()) {
                    println("${currentPlayer.name} lost the game!")
                    players.remove(currentPlayer)
                    if (currentPlayerIndex == players.size) {
                        currentPlayerIndex = 0
                    }
                } else {
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size
                }
            } else {
                println("Invalid block selection!")
            }
        }

        println("${players[0].name} won the game!")
    }

}