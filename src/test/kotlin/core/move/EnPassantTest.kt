package core.move

import core.GameBoardImpl
import org.junit.Test

class EnPassantTest {
    @Test
    fun test() {
        val board = GameBoardImpl()
        board.set(
            arrayOf(
                "....k...",
                "...p....",
                "........",
                "........",
                "....P...",
                "........",
                "........",
                "....K..."
            )
        )
        board.move(PawnSingleMove("e4", board).to("e5"))
        board.move(PawnDoubleMove("d7", board).to("d5"))
        board.move(EnPassant("e5", board).to("d6"))
        assert(board.capturedPieces.size == 1)
        assert(board.pieces.size == 3)
    }
}