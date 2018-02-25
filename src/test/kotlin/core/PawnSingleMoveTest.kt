package core

import core.move.PawnSingleMove
import core.piece.Bishop
import core.piece.Pawn
import org.junit.Test
import kotlin.test.assertEquals

class PawnSingleMoveTest {
    val board: GameBoard = GameBoardImpl()

    @Test
    fun testLegalMove() {
        val pawn = Pawn(Position.of("a2"), Player.WHITE)
        board.put(pawn)
        PawnSingleMove("a2", board).to("a3").move()
        assertEquals(Position.of("a3"), pawn.pos)
    }

    @Test(expected = RuntimeException::class)
    fun testIllegalMove() {
        val pawn = Pawn(Position.of("a2"), Player.WHITE)
        board.put(pawn)
        PawnSingleMove("a2", board).to("a4").move()
    }

    @Test(expected = IllegalArgumentException::class)
    fun testIllegalPiece() {
        board.put(Bishop(Position.of("c1"), Player.WHITE))
        PawnSingleMove("c1", board).to("c2")
    }
}
