package core.move

import core.*
import java.lang.Math.abs

class KnightMove(piecePosNotion: String, destNotion: String, board: GameBoard) : CapturableSingleMove(piecePosNotion, destNotion, board) {
    init {
        require(piece is Knight)
    }

    override fun isLegal(): Boolean {
        return (abs(dest.rank - piece.pos.rank) + abs(dest.file - piece.pos.file) == 3) and
                (dest.rank != piece.pos.rank) and (dest.file != piece.pos.file)
    }
}