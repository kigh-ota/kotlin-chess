package core

import org.junit.Assert.*
import org.junit.Test

class PawnRegularMoveTest {
    @Test
    fun testLegalMove() {
        val pawn = Pawn(Position(2, 1), Player.WHITE)
        val dest = Position(3, 1)
        PawnRegularMove(pawn, dest).move()
        assert(pawn.pos == dest)
    }

    @Test(expected = RuntimeException::class)
    fun testIllegalMove() {
        val pawn = Pawn(Position(2, 1), Player.WHITE)
        val dest = Position(4, 1)
        PawnRegularMove(pawn, dest).move()
    }
}
