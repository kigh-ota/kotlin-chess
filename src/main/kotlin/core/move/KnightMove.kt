package core.move

import core.GameBoard
import core.piece.Knight
import core.Position

class KnightMove(piecePosNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is Knight)
    }

    override fun possibleDestinations(): Set<Position> {
        return arrayOf(
            piece.pos.to(-2, -1),
            piece.pos.to(-2, 1),
            piece.pos.to(2, -1),
            piece.pos.to(2, 1),
            piece.pos.to(-1, -2),
            piece.pos.to(-1, 2),
            piece.pos.to(1, -2),
            piece.pos.to(1, 2)
        ).filterNotNull().filter { !isOccupiedBySelfPiece(it) }.toSet()
    }
}