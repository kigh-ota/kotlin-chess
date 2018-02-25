package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.Piece

abstract class SinglePieceMove(piecePosNotion: String, val board: GameBoard) : Move {
    protected val piece: Piece = board.pieceAt(piecePosNotion)!!
    protected var dest: Position? = null
    override val player: Player
        get() = piece.player

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

    override fun toString(): String {
        return "${piece.javaClass.simpleName} ${piece.pos} -> $dest"
    }
}