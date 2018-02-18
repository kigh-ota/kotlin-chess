package core.move

import core.Piece

interface Move {
    fun isLegal(): Boolean
    fun capturedPiece(): Piece?
    fun move()
}
