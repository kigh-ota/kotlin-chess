package core

data class Position(val rank: Int, val file: Int) {
    init {
        require(rank >= 1)
        require(rank <= GameBoard.SIZE)
        require(file >= 1)
        require(file <= GameBoard.SIZE)
    }

    companion object {
        fun of(notion: String): Position {
            require(notion.length == 2)
            val (fileChar, rankChar) = notion.toCharArray()

            require(fileChar >= 'a' && fileChar < 'a' + GameBoard.SIZE)
            val file: Int = fileChar - 'a' + 1

            require(rankChar.isDigit())
            val rank: Int = rankChar - '1' + 1
            require(rank >= 1 && rank <= GameBoard.SIZE)

            return Position(rank, file)
        }
    }
}