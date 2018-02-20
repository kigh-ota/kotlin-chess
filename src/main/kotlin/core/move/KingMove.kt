package core.move

import core.*

class KingMove(piecePosNotion: String, destNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, destNotion, board) {
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