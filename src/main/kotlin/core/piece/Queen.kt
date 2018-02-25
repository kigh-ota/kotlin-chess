package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.Move
import core.move.QueenMove

class Queen(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        return QueenMove(pos.toString(), board)
            .possibleDestinations().map { QueenMove(pos.toString(), board).to(it.toString()) }
            .toSet()
    }
}