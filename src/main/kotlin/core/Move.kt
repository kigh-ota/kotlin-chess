package core

interface Move {
    fun isLegal(): Boolean
    fun capturedPiece(): Piece?
    fun move()
}
