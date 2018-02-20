package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class CapturableSingleMove(piecePosNotion: String, destNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, destNotion, board) {
    override fun capturedPiece(): Piece? {
        val pieceAtDest = board.pieceAt(dest)
        return if (pieceAtDest?.player != piece.player)
            pieceAtDest
        else
            null
    }
}