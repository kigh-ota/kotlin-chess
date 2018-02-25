package core.piece

import core.GameBoard
import core.Player
import core.Position
import core.move.Move

interface Piece {
    val moveCount: Int
    val rank: Int
    val file: Int
    val player: Player
    var pos: Position
    fun moveTo(dest: Position?)
    fun possibleMoves(board: GameBoard): Set<Move>
}