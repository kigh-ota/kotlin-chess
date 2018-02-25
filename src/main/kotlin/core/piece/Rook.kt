package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.Move

class Rook(pos: Position, player: Player) : PieceImpl(pos, player) {
    override fun possibleMoves(board: GameBoard): Set<Move> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}