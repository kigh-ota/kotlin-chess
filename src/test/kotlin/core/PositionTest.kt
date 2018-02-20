package core

import org.junit.Assert.*
import org.junit.Test

class PositionTest {
    @Test
    fun testOf() {
        val pos = Position.of("g4")
        assert(pos.rank == 4)
        assert(pos.file == 7)
    }
}