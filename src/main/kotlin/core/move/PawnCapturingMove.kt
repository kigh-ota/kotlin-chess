package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.Pawn

class PawnCapturingMove(piecePosNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, board) {
    override fun possibleDestinations(): Set<Position> {
        return when (piece.player) {
            Player.WHITE -> arrayOf(piece.pos.to(1, -1), piece.pos.to(1, 1))
            Player.BLACK -> arrayOf(piece.pos.to(-1, -1), piece.pos.to(-1, 1))
        }.filterNotNull().filter { board.pieceAt(it) != null && board.pieceAt(it)?.player != piece.player }.toSet()
    }

    init {
        require(piece is Pawn)
    }
}