package core.move

import core.GameBoard
import core.Player
import core.Position
import core.piece.King
import core.piece.Piece

class QueenSideCastling(override val player: Player, val board: GameBoard) : Move {
    override val from: Position? = null
    override val dest: Position? = null
    private val rook: Piece? = board.pieceAt(if (player == Player.WHITE) "a1" else "a8")
    private val king: Piece? = board.pieces.first { it.player == player && it is King }

    override fun isLegal(): Boolean {
        if (rook == null || king == null) {
            return false
        }
        when (player) {
            Player.WHITE -> {
                if (arrayOf("e1", "d1", "c1").any {
                        Position.of(it).isUnderAttackBy(player.opponent, board).isNotEmpty()
                    }) return false
                if (arrayOf("b1", "c1", "d1").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
            Player.BLACK -> {
                if (arrayOf("e8", "d8", "c8").any {
                        Position.of(it).isUnderAttackBy(player.opponent, board).isNotEmpty()
                    }) return false
                if (arrayOf("b8", "c8", "d8").any {
                        board.pieceAt(it) != null
                    }) return false
                return rook.moveCount == 0 && king.moveCount == 0
            }
        }
    }

    override fun capturing(): Piece? {
        return null
    }

    override fun move() {
        rook!!
        king!!
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