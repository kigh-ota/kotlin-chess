package core.move

import core.*

class PawnCapturingMove(piecePosNotion: String, destNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun capturedPiece(): Piece? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}