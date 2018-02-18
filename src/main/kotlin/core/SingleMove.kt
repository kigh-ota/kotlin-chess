package core

abstract class SingleMove(val piece: Piece, val dest: Position) : Move {
    override fun move() {
        if (!isLegal()) {
            throw RuntimeException("Illegal Move")
        }
        piece.moveTo(dest)
    }
}