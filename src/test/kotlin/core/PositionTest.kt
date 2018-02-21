package core

import org.junit.Test
import kotlin.test.assertEquals

class PositionTest {
    @Test
    fun testOf() {
        val pos = Position.of("g4")
        assertEquals(4, pos.rank)
        assertEquals(7, pos.file)
    }
}