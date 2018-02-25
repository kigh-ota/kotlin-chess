package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.Pawn
import core.piece.Piece

class EnPassant(piecePosNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, board) {
    override fun possibleDestinations(): Set<Position> {
        val lastMove = board.record.lastOrNull()
        if (lastMove == null || lastMove !is PawnDoubleMove) {
            return setOf()
        }

        return when (piece.player) {
            Player.WHITE -> setOf(
                Position.maybe(5, lastMove.dest!!.file - 1),
                Position.maybe(5, lastMove.dest!!.file + 1)
            )
            Player.BLACK -> setOf(
                Position.maybe(4, lastMove.dest!!.file - 1),
                Position.maybe(4, lastMove.dest!!.file + 1)
            )
        }
            .filterNotNull()
            .filter { piece.pos == it }
            .mapNotNull {
                Position(
                    it.rank + (if (piece.player == Player.WHITE) 1 else -1),
                    lastMove.dest!!.file
                )
            }
            .toSet()
    }

    init {
        require(piece is Pawn)
    }

    override fun capturing(): Piece? {
        return board.pieceAt(_dest?.to(if (piece.player == Player.WHITE) -1 else 1, 0))
    }
}