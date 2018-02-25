package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.KingSideCastling
import core.move.Move
import core.move.QueenSideCastling
import core.move.RookMove

class Rook(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        val rookMoves = RookMove(pos.toString(), board)
            .possibleDestinations().map { RookMove(pos.toString(), board).to(it.toString()) }.toSet()
        val castling = when (player) {
            Player.WHITE -> when (pos.toString()) {
                "a1" -> QueenSideCastling(player, board)
                "h1" -> KingSideCastling(player, board)
                else -> null
            }
            Player.BLACK -> when (pos.toString()) {
                "a8" -> QueenSideCastling(player, board)
                "h8" -> KingSideCastling(player, board)
                else -> null
            }
        }
        return rookMoves
            .plus(if (castling != null && castling.isLegal()) setOf(castling) else setOf())
    }
}