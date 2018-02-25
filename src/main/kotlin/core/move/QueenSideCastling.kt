package core.move

import core.*
import core.piece.King
import core.piece.Piece

class QueenSideCastling(val board: GameBoard) : Move {
    private val rook: Piece = board.pieceAt(if (player == Player.WHITE) "a1" else "a8")!!
    private val king: Piece = board.pieces.first { it.player == player && it is King }
    override val player: Player
        get() = board.nextTurn

    override fun isLegal(): Boolean {
        when (player) {
            Player.WHITE -> {
                if (arrayOf("b1", "c1", "d1").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
            Player.BLACK -> {
                if (arrayOf("b8", "c8", "d8").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
        }
        // TODO validate king is not and will not be checked
    }

    override fun capturedPiece(): Piece? {
        return null
    }

    override fun move() {
        when (player) {
            Player.WHITE -> {
                rook.moveTo(Position.of("d1"))
                king.moveTo(Position.of("c1"))
            }
            Player.BLACK -> {
                rook.moveTo(Position.of("d8"))
                king.moveTo(Position.of("c8"))
            }
        }
    }
}