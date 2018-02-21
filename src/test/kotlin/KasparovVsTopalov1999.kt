
import core.GameBoardImpl
import core.Player
import core.move.*
import kotlin.test.assertEquals
import org.junit.Test

// http://www.chessgames.com/perl/chessgame?gid=1011478
class KasparovVsTopalov1999Test {
    @Test
    fun test() {
        val board = GameBoardImpl()
        board.setup()

        board.move(PawnDoubleMove("e2", board).to("e4"))
        board.move(PawnSingleMove("d7", board).to("d6"))

        board.move(PawnDoubleMove("d2", board).to("d4"))
        board.move(KnightMove("g8", board).to("f6"))

        board.move(KnightMove("b1", board).to("c3"))
        board.move(PawnSingleMove("g7", board).to("g6"))

        board.move(BishopMove("c1", board).to("e3"))
        board.move(BishopMove("f8", board).to("g7"))

        board.move(QueenMove("d1", board).to("d2"))
        board.move(PawnSingleMove("c7", board).to("c6"))

        board.move(PawnSingleMove("f2", board).to("f3"))
        board.move(PawnDoubleMove("b7", board).to("b5"))

        board.move(KnightMove("g1", board).to("e2"))
        board.move(KnightMove("b8", board).to("d7"))

        board.move(BishopMove("e3", board).to("h6"))
        board.move(BishopMove("g7", board).to("h6"))
        assertEquals(1, board.capturedPieces.size)

        board.move(QueenMove("d2", board).to("h6"))
        assertEquals(2, board.capturedPieces.size)
        board.move(BishopMove("c8", board).to("b7"))

        board.move(PawnSingleMove("a2", board).to("a3"))
        board.move(PawnDoubleMove("e7", board).to("e5"))

        board.move(QueenSideCastling(Player.WHITE, board))
        board.move(QueenMove("d8", board).to("e7"))

        board.move(KingMove("c1", board).to("b1"))
        board.move(PawnSingleMove("a7", board).to("a6"))

        board.move(KnightMove("e2", board).to("c1"))
        board.move(QueenSideCastling(Player.BLACK, board))

        board.move(KnightMove("c1", board).to("b3"))
//        board.move(PawnCapturingMove("e5", board).to("d4"))
    }
}