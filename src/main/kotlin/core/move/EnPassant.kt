package core.move

import core.*

class EnPassant(piece: Piece, dest: Position, board: GameBoard) : SingleMove(piece, dest, board) {
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