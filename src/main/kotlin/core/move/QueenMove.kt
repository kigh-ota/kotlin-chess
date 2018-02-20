package core.move

import core.*

class QueenMove(piecePosNotion: String, destNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, destNotion, board) {
    override fun isLegal(): Boolean {
        // FIXME 最初に塞いでる敵駒までしか進めない
        if ((piece.pos.rank == dest.rank) or (piece.pos.file == dest.file))
            return true
        if ((piece.pos.rank + piece.pos.file == dest.rank + dest.file) or
            (piece.pos.rank - piece.pos.file == dest.rank - dest.file)
        )
            return true
        return false
    }

    init {
        require(piece is Queen)
    }
}