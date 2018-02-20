package core.move

import core.*

class BishopMove(piece: Piece, dest: Position, board: GameBoard) : CapturableSingleMove(piece, dest, board) {
    init {
        require(piece is Bishop)
    }

    override fun isLegal(): Boolean {
        // FIXME 最初に塞いでる敵駒までしか進めない
        return (piece.pos.rank + piece.pos.file == dest.rank + dest.file) or
                (piece.pos.rank - piece.pos.file == dest.rank - dest.file)
    }
}