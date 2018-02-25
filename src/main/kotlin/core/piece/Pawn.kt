package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.*

class Pawn(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        return setOf(
            PawnSingleMove(pos.toString(), board).possibleDestinations()
                .map { PawnSingleMove(pos.toString(), board).to(it.toString()) }
                .toSet(),
            PawnDoubleMove(pos.toString(), board)
                .possibleDestinations().map { PawnDoubleMove(pos.toString(), board).to(it.toString()) }
                .toSet(),
            PawnCapturingMove(pos.toString(), board)
                .possibleDestinations().map { PawnCapturingMove(pos.toString(), board).to(it.toString()) }
                .toSet(),
            EnPassant(pos.toString(), board)
                .possibleDestinations().map { EnPassant(pos.toString(), board).to(it.toString()) }
                .toSet()
        )
            .flatten()
            .filter { it.isLegal() }
            .toSet()
    }
}
