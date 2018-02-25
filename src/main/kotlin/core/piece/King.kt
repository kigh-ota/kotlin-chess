package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.KingMove
import core.move.KingSideCastling
import core.move.Move

class King(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        val kingMoves = KingMove(pos.toString(), board)
            .possibleDestinations().map { KingMove(pos.toString(), board).to(it.toString()) }.toSet()
        val kingSideCastling = KingSideCastling(player, board)
        return kingMoves.plus(if (kingSideCastling.isLegal()) setOf(kingSideCastling) else setOf())
    }
}