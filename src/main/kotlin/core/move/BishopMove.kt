package core.move

import core.piece.Bishop
import core.GameBoard
import core.Position

class BishopMove(piecePosNotion: String, board: GameBoard) :
    CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is Bishop)
    }

    override fun possibleDestinations(): Set<Position> {
        val ret = mutableSetOf<Position>()
        ret.addAll(destinationsOnLine(piece.pos::toUpperLeft))
        ret.addAll(destinationsOnLine(piece.pos::toUpperRight))
        ret.addAll(destinationsOnLine(piece.pos::toLowerLeft))
        ret.addAll(destinationsOnLine(piece.pos::toLowerRight))
        return ret
    }
}
