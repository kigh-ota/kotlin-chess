package core.move

import core.*
import core.piece.Pawn
import core.piece.Piece

class PawnSingleMove(piecePosNotion: String, board: GameBoard) :
    SinglePieceMove(piecePosNotion, board) {

    init {
        require(piece is Pawn)
    }

    override fun capturing(): Piece? {
        return null;
    }

    override fun possibleDestinations(): Set<Position> {
        val pos = when (piece.player) {
            Player.WHITE -> piece.pos.toUpper(1)
            Player.BLACK -> piece.pos.toLower(1)
        }
        return if (pos != null && board.pieceAt(pos) == null) setOf(pos) else emptySet()
    }
}
