package core.move

import core.GameBoard
import core.Position
import core.piece.Piece

abstract class CapturableSingleMove(piecePosNotion: String, board: GameBoard) : SinglePieceMove(piecePosNotion, board) {
    override fun capturing(): Piece? {
        val pieceAtDest = board.pieceAt(_dest)
        return if (pieceAtDest?.player != piece.player)
            pieceAtDest
        else
            null
    }

    protected fun destinationsOnLine(f: (Int) -> Position?): Set<Position> {
        val ret = mutableSetOf<Position>()
        for (i in 1..GameBoard.SIZE) {
            val pos = f(i) ?: break
            val destPiece = board.pieceAt(pos)
            if (destPiece == null || destPiece.player != piece.player) ret.add(pos)
            if (destPiece != null) break
        }
        return ret
    }

    protected fun isOccupiedBySelfPiece(pos: Position): Boolean {
        val p = board.pieceAt(pos)
        if (p != null && p.player == piece.player) return true
        return false
    }
}