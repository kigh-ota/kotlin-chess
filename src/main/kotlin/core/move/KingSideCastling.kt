package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.King
import core.piece.Piece

class KingSideCastling(override val player: Player, val board: GameBoard) : Move {
    private val rook: Piece = board.pieceAt(if (player == Player.WHITE) "h1" else "h8")!!
    private val king: Piece = board.pieces.first { it.player == player && it is King }

    override fun isLegal(): Boolean {
        when (player) {
            Player.WHITE -> {
                if (arrayOf("f1", "g1").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
            Player.BLACK -> {
                if (arrayOf("f8", "g8").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
        }
        // TODO validate king is not and will not be checked
    }

    override fun capturing(): Piece? {
        return null
    }

    override fun move() {
        when (player) {
            Player.WHITE -> {
                rook.moveTo(Position.of("f1"))
                king.moveTo(Position.of("g1"))
            }
            Player.BLACK -> {
                rook.moveTo(Position.of("f8"))
                king.moveTo(Position.of("g8"))
            }
        }
    }
}