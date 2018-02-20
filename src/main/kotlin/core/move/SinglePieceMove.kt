package core.move

import core.GameBoard
import core.Piece
import core.Position

abstract class SinglePieceMove(piecePosNotion: String, destNotion: String, val board: GameBoard) : Move {
    protected val piece: Piece = board.pieceAt(piecePosNotion)!!
    protected val dest: Position = Position.of(destNotion)

    init {
        require(!isBlockedBySelfPiece())
    }

    override fun move() {
        if (!isLegal()) {
            throw RuntimeException("Illegal Move")
        }
        piece.moveTo(dest)
    }

    private fun isBlockedBySelfPiece() = board.pieceAt(dest)?.player == piece.player
}