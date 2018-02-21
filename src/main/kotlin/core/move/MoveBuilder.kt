package core.move

import core.*

class MoveBuilder(val src: String, val dest: String, val board: GameBoard) {
    fun build(): SinglePieceMove {
        val piece = board.pieceAt(src)
        checkNotNull(piece)
        return when (piece) {
            is King -> KingMove(src, board).to(dest)
            is Queen -> QueenMove(src, board).to(dest)
            is Bishop -> BishopMove(src, board).to(dest)
            is Knight -> KnightMove(src, board).to(dest)
            is Rook -> RookMove(src, board).to(dest)
            is Pawn ->
                arrayOf(
                    PawnSingleMove(src, board).to(dest),
                    PawnDoubleMove(src, board).to(dest),
                    PawnCapturingMove(src, board).to(dest),
                    EnPassant(src, board).to(dest)
                ).first { it.isLegal() }
            else -> throw RuntimeException()
        }
    }
}