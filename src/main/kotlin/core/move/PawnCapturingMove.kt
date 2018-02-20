package core.move

import core.*

class PawnCapturingMove(piece: Piece, dest: Position, board: GameBoard) : SinglePieceMove(piece, dest, board) {
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