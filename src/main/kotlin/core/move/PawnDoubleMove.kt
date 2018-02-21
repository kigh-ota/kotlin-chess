package core.move

import core.GameBoard
import core.Pawn
import core.Player
import core.Position

class PawnDoubleMove(piecePosNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, board) {
    init {
        require(piece is Pawn)
    }

    override fun possibleDestinations(): Set<Position> {
        if (piece.moveCount != 0) return emptySet()
        val pos1 = when (piece.player) {
            Player.WHITE -> piece.pos.toUpper(1)
            Player.BLACK -> piece.pos.toLower(1)
        }
        val pos2 = when (piece.player) {
            Player.WHITE -> piece.pos.toUpper(2)
            Player.BLACK -> piece.pos.toLower(2)
        }
        return if (pos2 != null && board.pieceAt(pos1) == null && board.pieceAt(pos2) == null) setOf(pos2) else emptySet()
    }
}