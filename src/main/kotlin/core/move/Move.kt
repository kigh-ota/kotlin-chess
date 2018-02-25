package core.move

import core.Player
import core.Position
import core.piece.Piece

/**
 * Representation of a move.
 * An instance for an illegal move can be created, but calling the move() function should fail.
 */
interface Move {
    val player: Player
    val from: Position?
    val dest: Position?
    fun isLegal(): Boolean
    fun capturing(): Piece?
    fun move()
}
