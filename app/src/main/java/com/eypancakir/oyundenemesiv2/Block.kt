package com.eypancakir.oyundenemesiv2

class Block {
    private var color: String = "WHITE"  // Block rengi
    private var owner: Player? = null  // Block sahibi

    fun setColor(color: String) {
        this.color = color
    }

    fun getColor(): String {
        return color
    }

    fun setOwner(player: Player) {
        this.owner = player
    }

    fun getOwner(): Player? {
        return owner
    }
}
