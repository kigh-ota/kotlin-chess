import core.GameBoardImpl
import core.King
import core.Player
import core.Position
import core.move.PawnSingleMove
import org.junit.Test

// http://www.chessgames.com/perl/chessgame?gid=1011478
class KasparovVsTopalov1999Test {
    @Test
    fun test() {
        val board = GameBoardImpl()
        board.setup()
        board.move(PawnSingleMove(board.pieceAt(Position.of("e2"))!!, Position.of("e4"), board))
        board.move(PawnSingleMove(board.pieceAt(Position.of("d7"))!!, Position.of("d6"), board))
    }
}