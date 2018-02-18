package core

import org.junit.Test

class GameBoardImplTest {
    private val sut = GameBoardImpl()

    @Test
    fun pieceAt() {
        sut.setup()

        val whiteKing = sut.pieceAt(Position(1, 5))
        assert(whiteKing?.player == Player.WHITE)
        assert(whiteKing is King)

        val none = sut.pieceAt(Position(3, 5))
        assert(none == null)
    }
}