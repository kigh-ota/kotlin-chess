package core

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GameBoardImplTest {
    private val sut = GameBoardImpl()

    @Test
    fun pieceAt() {
        sut.setup()

        val whiteKing = sut.pieceAt(Position(1, 5))
        assertEquals(Player.WHITE, whiteKing?.player)
        assertTrue(whiteKing is King)

        val none = sut.pieceAt(Position(3, 5))
        assertNull(none)
    }
}