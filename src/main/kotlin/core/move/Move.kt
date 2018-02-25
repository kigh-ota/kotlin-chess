package core.move

import core.Player
import core.piece.Piece

/**
 * Representation of a move.
 * An instance for an illegal move can be created, but calling the move() function should fail.
 */
interface Move {
    val player: Player
    fun isLegal(): Boolean
    fun capturedPiece(): Piece?
    fun move()
}
