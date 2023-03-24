import java.util.*

fun main(args: Array<String>) {
    println(
        minReorder(
            6,
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(1,3),
                intArrayOf(2,3),
                intArrayOf(4,0),
                intArrayOf(4,5),
            )
        )
    )

    println(
        minReorder(
            5,
            arrayOf(
                intArrayOf(1,0),
                intArrayOf(1,2),
                intArrayOf(3,2),
                intArrayOf(3,4),
            )
        )
    )

    println(
        minReorder(
            3,
            arrayOf(
                intArrayOf(1,0),
                intArrayOf(2,0),
            )
        )
    )
}

fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val visited = IntArray(n)
    val ways = Array(n) { LinkedList<Int>() }

    var change = 0

    connections.forEach {
        ways[it[0]].add(it[1])
    }

    ways.indices.forEach { index ->
        if (visited[index] != 1){
            change += dfs(visited, ways, index)
        }
    }

    return change
}

private fun dfs(
    visited: IntArray,
    ways: Array<LinkedList<Int>>,
    currentCity: Int
): Int {
    var countChange = 0

    visited[currentCity] = 1
    ways[currentCity].forEach { nextCity ->
        if (visited[nextCity] == 0){
            countChange += dfs(visited, ways, nextCity) + 1
        }
    }

    return countChange
}