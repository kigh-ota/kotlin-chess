package core

import core.move.Move

interface GameBoard {
    val pieces: Set<Piece>
    val record: List<Move>
    fun setup()
    fun set(strs: Array<String>)
    fun move(move: Move)
    fun put(piece: Piece)
    fun pieceAt(pos: Position?): Piece?
    fun pieceAt(notion: String): Piece?

    companion object {
        const val SIZE = 8
    }
}
