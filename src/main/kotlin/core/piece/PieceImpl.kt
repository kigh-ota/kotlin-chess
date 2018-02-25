package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.SinglePieceMove

abstract class PieceImpl(override var pos: Position, override val player: Player): Piece {
    private var _moveCount = 0
    override val moveCount: Int
        get() = _moveCount

    override fun moveTo(dest: Position?) {
        if (dest == null) throw RuntimeException("Illegal Destination")
        pos = dest
        _moveCount++
    }

    override fun isBeingAttackedBy(board: GameBoard): Set<Piece> {
        return board
            .possibleMoves(this.player.opponent)
            .filter { it.capturing()?.pos == this.pos }
            .map { (it as SinglePieceMove).piece }
            .toSet()
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} ${this.pos}"
    }
}
