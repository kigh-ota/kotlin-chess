package core.move

import core.*

class PawnDoubleMove(piece: Piece, dest: Position, board: GameBoard) : SingleMove(piece, dest, board) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun capturedPiece(): Piece? {
        return null
    }
}