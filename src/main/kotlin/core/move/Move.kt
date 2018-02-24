package core.move

import core.Piece
import core.Player

interface Move {
    val player: Player
    fun isLegal(): Boolean
    fun capturedPiece(): Piece?
    fun move()
}
