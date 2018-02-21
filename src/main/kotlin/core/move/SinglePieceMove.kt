package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class SinglePieceMove(piecePosNotion: String, val board: GameBoard) : Move {
    protected val piece: Piece = board.pieceAt(piecePosNotion)!!
    protected var dest: Position? = null

    fun to(notion: String): SinglePieceMove {
        dest = Position.of(notion)
        return this
    }

    override fun move() {
        if (!isLegal()) throw RuntimeException("Illegal Move")
        piece.moveTo(dest)
    }

    override fun isLegal(): Boolean {
        return possibleDestinations().contains(dest)
    }

    abstract fun possibleDestinations(): Set<Position>

    override fun capturedPiece(): Piece? {
        return null
    }
}