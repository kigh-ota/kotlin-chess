package core.move

import core.*

class KingMove(piece: Piece, dest: Position, board: GameBoard) : CapturableSingleMove(piece, dest, board) {
    init {
        require(piece is King)
    }

    override fun isLegal(): Boolean {
        return (dest.rank >= piece.pos.rank - 1) and
                (dest.rank <= piece.pos.rank + 1) and
                (dest.file >= piece.pos.file - 1) and
                (dest.file <= piece.pos.file + 1)
    }
}