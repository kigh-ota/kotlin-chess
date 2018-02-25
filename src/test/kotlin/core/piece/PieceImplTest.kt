package core.piece

import core.GameBoardImpl
import org.junit.Test

class PieceImplTest {

    @Test
    fun isBeingAttackedBy() {
        val board = GameBoardImpl()
        board.set(
            arrayOf(
                "........",
                "..bn..b.",
                "...ppP..",
                "q...K...",
                "........",
                "........",
                "........",
                "........"
            )
        )
        val attacking = board.pieceAt("e5")!!.isBeingAttackedBy(board)
        assert(attacking.size == 3)
    }
}