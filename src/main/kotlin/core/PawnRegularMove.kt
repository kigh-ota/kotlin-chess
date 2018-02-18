package core

class PawnRegularMove(piece: Piece, dest: Position) : SingleMove(piece, dest) {
    init {
        require(piece is Pawn)
    }

    override fun isLegal(): Boolean {
        return when (piece.player) {
            Player.WHITE -> dest.rank == piece.pos.rank + 1
            Player.BLACK -> dest.rank == piece.pos.rank - 1
        }
    }

    override fun capturedPiece(): Piece? {
        return null;
    }
}