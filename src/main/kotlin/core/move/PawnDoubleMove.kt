package core.move

import core.GameBoard
import core.Pawn
import core.Piece
import core.Player

class PawnDoubleMove(piecePosNotion: String, destNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        if (piece.moveCount != 0) {
            return false
        }
        if (dest.file != piece.pos.file)
            return false
        return when (piece.player) {
            Player.WHITE -> dest.rank == piece.pos.rank + 2
            Player.BLACK -> dest.rank == piece.pos.rank - 2
        }
    }

    override fun capturedPiece(): Piece? {
        return null
    }
}