package core.move

import core.Bishop
import core.GameBoard
import core.Piece
import core.Position
import java.lang.Math.abs

class KnightMove(piece: Piece, dest: Position, board: GameBoard) : CapturableSingleMove(piece, dest, board) {
    init {
        require(piece is Bishop)
    }

    override fun isLegal(): Boolean {
        return (abs(dest.rank - piece.pos.rank) + abs(dest.file - piece.pos.file) == 3) and
                (dest.rank != piece.pos.rank) and (dest.file != piece.pos.file)
    }
}