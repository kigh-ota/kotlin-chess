package core.move

import core.*

class PawnSingleMove(piecePosNotion: String, destNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        if (dest.file != piece.pos.file)
            return false
        return when (piece.player) {
            Player.WHITE -> dest.rank == piece.pos.rank + 1
            Player.BLACK -> dest.rank == piece.pos.rank - 1
        }
    }

    override fun capturedPiece(): Piece? {
        return null;
    }
}