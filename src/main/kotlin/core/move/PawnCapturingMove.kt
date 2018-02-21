package core.move

import core.GameBoard
import core.Pawn
import core.Piece
import core.Position

class PawnCapturingMove(piecePosNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, board) {
    override fun possibleDestinations(): Set<Position> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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