package core.move

import core.GameBoard
import core.Piece
import core.Rook

class RookMove(piecePosNotion: String, destNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Rook)
    }

    override fun isLegal(): Boolean {
        // FIXME 最初に塞いでる敵駒までしか進めない
        return (piece.pos.rank == dest.rank) or (piece.pos.file == dest.file)
    }

    override fun capturedPiece(): Piece? {
        val pieceAtDest = board.pieceAt(dest)
        return if (pieceAtDest?.player != piece.player)
            pieceAtDest
        else
            null
    }
}