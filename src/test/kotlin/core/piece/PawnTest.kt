package core.piece

import core.GameBoardImpl
import org.junit.Test

class PawnTest {

    @Test
    fun possibleMoves() {
        val board = GameBoardImpl()
        board.setup()
        val actual = board.pieceAt("e2")!!.possibleMoves(board)
        assert(actual.size == 2)
    }
}