package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.BishopMove
import core.move.Move

class Bishop(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        return BishopMove(pos.toString(), board)
            .possibleDestinations().map { BishopMove(pos.toString(), board).to(it.toString()) }
            .toSet()
    }
}