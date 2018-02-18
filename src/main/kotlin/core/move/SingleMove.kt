package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class SingleMove(val piece: Piece, val dest: Position, val board: GameBoard) : Move {
    override fun move() {
        if (!isLegal()) {
            throw RuntimeException("Illegal Move")
        }
        piece.moveTo(dest)
    }

    protected fun isBlockedBySelfPiece() = board.pieceAt(dest)?.player == piece.player
}