import core.GameBoardImpl
import core.move.KnightMove
import core.move.PawnDoubleMove
import core.move.PawnSingleMove
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
    }
}