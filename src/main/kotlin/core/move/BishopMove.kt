package core.move

import core.*

class BishopMove(piecePosNotion: String, destNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Bishop)
    }

    override fun isLegal(): Boolean {
        // FIXME 最初に塞いでる敵駒までしか進めない
        return (piece.pos.rank + piece.pos.file == dest.rank + dest.file) or
                (piece.pos.rank - piece.pos.file == dest.rank - dest.file)
    }
}