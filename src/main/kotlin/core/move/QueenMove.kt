package core.move

import core.GameBoard
import core.Position
import core.piece.Queen

class QueenMove(piecePosNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is Queen)
    }

    override fun possibleDestinations(): Set<Position> {
        val ret = mutableSetOf<Position>()
        ret.addAll(destinationsOnLine(piece.pos::toUpper))
        ret.addAll(destinationsOnLine(piece.pos::toLower))
        ret.addAll(destinationsOnLine(piece.pos::toLeft))
        ret.addAll(destinationsOnLine(piece.pos::toRight))
        ret.addAll(destinationsOnLine(piece.pos::toUpperLeft))
        ret.addAll(destinationsOnLine(piece.pos::toUpperRight))
        ret.addAll(destinationsOnLine(piece.pos::toLowerLeft))
        ret.addAll(destinationsOnLine(piece.pos::toLowerRight))
        return ret
    }
}