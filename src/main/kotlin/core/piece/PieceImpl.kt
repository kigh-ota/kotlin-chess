package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.Move

abstract class PieceImpl(override var pos: Position, override val player: Player): Piece {
    private var _moveCount = 0
    override val moveCount: Int
        get() = _moveCount

    override val rank: Int
        get() = pos.rank

    override val file: Int
        get() = pos.file

    override fun moveTo(dest: Position?) {
        if (dest == null) throw RuntimeException("Illegal Destination")
        pos = dest
        _moveCount++
    }

    override fun possibleMoves(board: GameBoard): Set<Move> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
