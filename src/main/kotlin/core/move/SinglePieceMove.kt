package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.Piece

abstract class SinglePieceMove(piecePosNotion: String, val board: GameBoard) : Move {
    val piece: Piece = board.pieceAt(piecePosNotion)!!
    override val from: Position? = Position.of(piecePosNotion)
    protected var _dest: Position? = null
    override val dest: Position?
        get() = _dest
    override val player: Player
        get() = piece.player

    fun to(notion: String): SinglePieceMove {
        _dest = Position.of(notion)
        return this
    }

    override fun move() {
        if (!isLegal()) throw RuntimeException("Illegal Move")
        piece.moveTo(_dest)
    }

    override fun isLegal(): Boolean {
        return possibleDestinations().contains(_dest)
    }

    abstract fun possibleDestinations(): Set<Position>

    override fun capturing(): Piece? {
        return null
    }

    override fun toString(): String {
        return "${piece.javaClass.simpleName} $from -> $dest"
    }
}