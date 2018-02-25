package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.KnightMove
import core.move.Move

class Knight(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        return KnightMove(pos.toString(), board)
            .possibleDestinations().map { KnightMove(pos.toString(), board).to(it.toString()) }
            .toSet()
    }
}