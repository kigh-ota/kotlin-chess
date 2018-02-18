package core

interface GameBoard {
    fun setup()
    fun move(move: Move)
    fun record(): List<Move>
}
