package core

import core.move.PawnSingleMove
import org.junit.Test

class PawnSingleMoveTest {
    val board : GameBoard = GameBoardImpl()

    @Test
    fun testLegalMove() {
        val pawn = Pawn(Position(2, 1), Player.WHITE)
        val dest = Position(3, 1)
        PawnSingleMove(pawn, dest, board).move()
        assert(pawn.pos == dest)
    }

    @Test(expected = RuntimeException::class)
    fun testIllegalMove() {
        val pawn = Pawn(Position(2, 1), Player.WHITE)
        val dest = Position(4, 1)
        PawnSingleMove(pawn, dest, board).move()
    }

    @Test(expected = IllegalArgumentException::class)
    fun testIllegalPiece() {
        PawnSingleMove(Bishop(Position(1, 3), Player.WHITE), Position(2, 3), board)
    }
}
