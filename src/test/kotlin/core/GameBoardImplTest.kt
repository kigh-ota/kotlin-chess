package core

import core.move.PawnDoubleMove
import core.move.PawnSingleMove
import core.piece.King
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

    @Test
    fun possibleMoves() {
        sut.setup()
        val actual = sut.possibleMoves(Player.WHITE)
        assert(actual.size == 20)
    }

    @Test
    fun possibleMoves2() {
        sut.setup()
        sut.move(PawnDoubleMove("e2", sut).to("e4"))
        sut.move(PawnDoubleMove("e7", sut).to("e5"))
        val actual = sut.possibleMoves(Player.WHITE)
        assert(actual.size == 29)
    }

    @Test
    fun possibleMoves3() {
        sut.setup()
        sut.move(PawnDoubleMove("e2", sut).to("e4"))
        sut.move(PawnSingleMove("e7", sut).to("e6"))
        val actual = sut.possibleMoves(Player.WHITE)
        assert(actual.size == 30)
    }
}