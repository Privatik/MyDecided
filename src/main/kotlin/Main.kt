fun main(args: Array<String>) {
    println(
        minScore(
            4,
            arrayOf(
                intArrayOf(1,2,9),
                intArrayOf(2,3,6),
                intArrayOf(2,4,5),
                intArrayOf(1,4,7),
            )
        )
    )

    println(
        minScore(
            4,
            arrayOf(
                intArrayOf(1,2,2),
                intArrayOf(1,3,4),
                intArrayOf(3,4,7),
            )
        )
    )
}

fun minScore(n: Int, roads: Array<IntArray>): Int {
    val isVisited = hashSetOf<Int>()

    roads.forEach {

    }

}