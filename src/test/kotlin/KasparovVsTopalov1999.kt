
import core.GameBoardImpl
import core.Player
import core.move.*
import org.junit.Test
import kotlin.test.assertEquals

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
        board.move(PawnCapturingMove("e5", board).to("d4"))
        assertEquals(3, board.capturedPieces.size)

        board.move(RookMove("d1", board).to("d4"))
        assertEquals(4, board.capturedPieces.size)
        board.move(PawnSingleMove("c6", board).to("c5"))

        board.move(RookMove("d4", board).to("d1"))
        board.move(KnightMove("d7", board).to("b6"))

        board.move(PawnSingleMove("g2", board).to("g3"))
        board.move(KingMove("c8", board).to("b8"))

        board.move(KnightMove("b3", board).to("a5"))
        board.move(BishopMove("b7", board).to("a8"))

        board.move(BishopMove("f1", board).to("h3"))
        board.move(PawnSingleMove("d6", board).to("d5"))

        board.move(QueenMove("h6", board).to("f4"))
        board.move(KingMove("b8", board).to("a7"))

        board.move(RookMove("h1", board).to("e1"))
        board.move(PawnSingleMove("d5", board).to("d4"))

        board.move(KnightMove("c3", board).to("d5"))
        board.move(KnightMove("b6", board).to("d5"))
        assertEquals(5, board.capturedPieces.size)

        board.move(PawnCapturingMove("e4", board).to("d5"))
        assertEquals(6, board.capturedPieces.size)
        board.move(QueenMove("e7", board).to("d6"))

        board.move(RookMove("d1", board).to("d4"))
        board.move(PawnCapturingMove("c5", board).to("d4"))

        board.move(RookMove("e1", board).to("e7"))
        board.move(KingMove("a7", board).to("b6"))

        board.move(QueenMove("f4", board).to("d4"))
        board.move(KingMove("b6", board).to("a5"))

        board.move(PawnDoubleMove("b2", board).to("b4"))
        board.move(KingMove("a5", board).to("a4"))

        board.move(QueenMove("d4", board).to("c3"))
        board.move(QueenMove("d6", board).to("d5"))

        board.move(RookMove("e7", board).to("a7"))
        board.move(BishopMove("a8", board).to("b7"))

        board.move(RookMove("a7", board).to("b7"))
        board.move(QueenMove("d5", board).to("c4"))

        board.move(QueenMove("c3", board).to("f6"))
        board.move(KingMove("a4", board).to("a3"))

        board.move(QueenMove("f6", board).to("a6"))
        board.move(KingMove("a3", board).to("b4"))

        board.move(PawnSingleMove("c2", board).to("c3"))
        board.move(KingMove("b4", board).to("c3"))

        board.move(QueenMove("a6", board).to("a1"))
        board.move(KingMove("c3", board).to("d2"))

        board.move(QueenMove("a1", board).to("b2"))
        board.move(KingMove("d2", board).to("d1"))

        board.move(BishopMove("h3", board).to("f1"))
        board.move(RookMove("d8", board).to("d2"))

        board.move(RookMove("b7", board).to("d7"))
        board.move(RookMove("d2", board).to("d7"))

        board.move(BishopMove("f1", board).to("c4"))
        board.move(PawnCapturingMove("b5", board).to("c4"))

        board.move(QueenMove("b2", board).to("h8"))
        board.move(RookMove("d7", board).to("d3"))

        board.move(QueenMove("h8", board).to("a8"))
        board.move(PawnSingleMove("c4", board).to("c3"))

        board.move(QueenMove("a8", board).to("a4"))
        board.move(KingMove("d1", board).to("e1"))

        board.move(PawnSingleMove("f3", board).to("f4"))
        board.move(PawnDoubleMove("f7", board).to("f5"))

        board.move(KingMove("b1", board).to("c1"))
        board.move(RookMove("d3", board).to("d2"))

        board.move(QueenMove("a4", board).to("a7"))
    }
}