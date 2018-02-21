package core.move

import core.GameBoardImpl
import core.Position
import junit.framework.Assert.assertEquals
import org.junit.Test

class BishopMoveTest {

    @Test
    fun possibleDestinations() {
        val board = GameBoardImpl()
        board.set(
            arrayOf(
                "........",
                "...B....",
                "........",
                ".B...b..",
                "........",
                "........",
                "........",
                "........"
            )
        )
        assertEquals(
            setOf(
                Position.of("c8"),
                Position.of("e8"),
                Position.of("c6"),
                Position.of("e6"),
                Position.of("f5")
            ), BishopMove("d7", board).possibleDestinations()
        )
    }
}
