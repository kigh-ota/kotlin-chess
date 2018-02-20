package core

import core.move.Move

interface GameBoard {
    val size: Int
    val pieces: Set<Piece>
    val record: List<Move>
    fun setup()
    fun move(move: Move)
    fun put(piece: Piece)
    fun pieceAt(pos: Position): Piece?
    fun pieceAt(notion: String): Piece?

    companion object {
        const val SIZE = 8
    }
}
