package core.move

import core.GameBoard
import core.Position
import core.piece.Rook

class RookMove(piecePosNotion: String, board: GameBoard) :
    CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is Rook)
    }

    override fun possibleDestinations(): Set<Position> {
        val ret = mutableSetOf<Position>()
        ret.addAll(destinationsOnLine(piece.pos::toUpper))
        ret.addAll(destinationsOnLine(piece.pos::toLower))
        ret.addAll(destinationsOnLine(piece.pos::toLeft))
        ret.addAll(destinationsOnLine(piece.pos::toRight))
        return ret
    }
}