package core.move

import core.GameBoard
import core.piece.Pawn
import core.piece.Piece
import core.Position

class EnPassant(piecePosNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, board) {
    override fun possibleDestinations(): Set<Position> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        require(piece is Pawn)
    }

    override fun capturedPiece(): Piece? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isLegal(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}