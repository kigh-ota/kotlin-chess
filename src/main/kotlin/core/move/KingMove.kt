package core.move

import core.GameBoard
import core.piece.King
import core.Position

class KingMove(piecePosNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, board) {
    init {
        require(piece is King)
    }

    override fun possibleDestinations(): Set<Position> {
        return arrayOf(
            piece.pos.toUpper(1),
            piece.pos.toLower(1),
            piece.pos.toLeft(1),
            piece.pos.toRight(1),
            piece.pos.toUpperLeft(1),
            piece.pos.toUpperRight(1),
            piece.pos.toLowerLeft(1),
            piece.pos.toLowerRight(1)
        ).filterNotNull().filter { !isOccupiedBySelfPiece(it) }.toSet()
    }
}