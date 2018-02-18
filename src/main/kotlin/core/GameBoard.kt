package core

import core.move.Move

interface GameBoard {
    val size: Int
    val pieces: Set<Piece>
    val record: List<Move>
    fun setup()
    fun move(move: Move)
    fun pieceAt(pos: Position): Piece?

    companion object {
        const val SIZE = 8
    }
}
