package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class SinglePieceMove(val piece: Piece, val dest: Position, val board: GameBoard) : Move {
    init {
        require(!isBlockedBySelfPiece())
    }

    override fun move() {
        if (!isLegal()) {
            throw RuntimeException("Illegal Move")
        }
        piece.moveTo(dest)
    }

    private fun isBlockedBySelfPiece() = board.pieceAt(dest)?.player == piece.player
}