package core.move

import core.GameBoard
import core.Position
import core.Rook

class RookMove(piecePosNotion: String, board: GameBoard) :
    CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is Rook)
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