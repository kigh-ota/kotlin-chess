package core

import core.move.PawnSingleMove
import org.junit.Test

class PawnSingleMoveTest {
    val board : GameBoard = GameBoardImpl()

    @Test
    fun testLegalMove() {
        val pawn = Pawn(Position.of("a2"), Player.WHITE)
        board.put(pawn)
        PawnSingleMove("a2", "a3", board).move()
        assert(pawn.pos == Position.of("a3"))
    }

    @Test(expected = RuntimeException::class)
    fun testIllegalMove() {
        val pawn = Pawn(Position.of("a2"), Player.WHITE)
        board.put(pawn)
        PawnSingleMove("a2", "a4", board).move()
    }

    @Test(expected = IllegalArgumentException::class)
    fun testIllegalPiece() {
        board.put(Bishop(Position.of("c1"), Player.WHITE))
        PawnSingleMove("c1", "c2", board)
    }
}
