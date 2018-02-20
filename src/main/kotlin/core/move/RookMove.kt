package core.move

import core.*

class RookMove(piece: Piece, dest: Position, board: GameBoard) : CapturableSingleMove(piece, dest, board) {
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