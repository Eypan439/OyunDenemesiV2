package com.eypancakir.oyundenemesiv2

class Player(val name: String, val color: String) {
    val blocks = mutableListOf<Block>()

    init {
        for (i in 0..9) {
            val block = Block()
            block.setColor(color)
            block.setOwner(this)
            blocks.add(block)
        }
    }

    fun getBlock(index: Int): Block {
        return blocks[index]
    }

    fun removeBlock(block: Block) {
        blocks.remove(block)
    }
}
