package core.move

import core.*

class PawnRegularMove(piece: Piece, dest: Position, board: GameBoard) : SingleMove(piece, dest, board) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        if (isBlockedBySelfPiece())
            return false
        if (dest.file != piece.pos.file)
            return false
        return when (piece.player) {
            Player.WHITE -> dest.rank == piece.pos.rank + 1
            Player.BLACK -> dest.rank == piece.pos.rank - 1
        }
    }

    override fun capturedPiece(): Piece? {
        return null;
    }
}