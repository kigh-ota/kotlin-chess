package core

import core.move.Move
import core.piece.Piece

interface GameBoard {
    val pieces: Set<Piece>
    val record: List<Move>
    val nextTurn: Player
    fun setup()
    fun set(strs: Array<String>)
    fun move(move: Move)
    fun put(piece: Piece)
    fun pieceAt(pos: Position?): Piece?
    fun pieceAt(notion: String): Piece?
    fun possibleMoves(player: Player): Set<Move>
    fun isInCheck(player: Player): Boolean

    companion object {
        const val SIZE = 8
    }
}
