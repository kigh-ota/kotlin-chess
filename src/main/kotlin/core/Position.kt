package core

data class Position(val rank: Int, val file: Int) {
    init {
        require(rank >= 1)
        require(rank <= GameBoard.SIZE)
        require(file >= 1)
        require(file <= GameBoard.SIZE)
    }
}