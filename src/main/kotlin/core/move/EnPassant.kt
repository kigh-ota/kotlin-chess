package core.move

import core.GameBoard
import core.Position
import core.piece.Pawn
import core.piece.Piece

class EnPassant(piecePosNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, board) {
    override fun possibleDestinations(): Set<Position> {
        return setOf() // TODO
    }

    init {
        require(piece is Pawn)
    }

    override fun capturing(): Piece? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isLegal(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}