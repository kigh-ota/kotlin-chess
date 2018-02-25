package core.piece;

import core.GameBoardImpl
import org.junit.Test

public class KnightTest {
    @Test
    fun possibleDestinations() {
        val board = GameBoardImpl()
        board.setup()
        val actual = board.pieceAt("b1")!!.possibleMoves(board)
        assert(actual.size == 2)
    }
}