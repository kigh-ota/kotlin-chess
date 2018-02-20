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
        board.move(PawnDoubleMove("e2", "e4", board))
        board.move(PawnSingleMove("d7", "d6", board))
        board.move(PawnDoubleMove("d2", "d4", board))
        board.move(KnightMove("g8", "f6", board))
        board.move(KnightMove("b1", "c3", board))
        board.move(PawnSingleMove("g7", "g6", board))
    }
}