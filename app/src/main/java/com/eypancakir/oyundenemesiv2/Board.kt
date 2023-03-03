package com.eypancakir.oyundenemesiv2

class Board {
    private val board = Array(10) { Array(10) { Block() } }

    fun printBoard() {
        for (i in 0..9) {
            for (j in 0..9) {
                print(board[i][j].getColor() + " ")
            }
            println()
        }
    }
}
