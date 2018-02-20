package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class CapturableSingleMove(piece: Piece, dest: Position, board: GameBoard) : SinglePieceMove(piece, dest, board) {
    override fun capturedPiece(): Piece? {
        val pieceAtDest = board.pieceAt(dest)
        return if (pieceAtDest?.player != piece.player)
            pieceAtDest
        else
            null
    }
}