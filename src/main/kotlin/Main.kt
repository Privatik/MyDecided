import java.util.*
import kotlin.math.abs

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

    println(
        minReorder(
            3,
            arrayOf(
                intArrayOf(1,2),
                intArrayOf(2,0),
            )
        )
    )


    println(
        minReorder(
            6,
            arrayOf(
                intArrayOf(0,2),
                intArrayOf(0,3),
                intArrayOf(4,1),
                intArrayOf(4,5),
                intArrayOf(5,0),
            )
        )
    )
}

fun dfs(
    al: Array<LinkedList<Int>>,
    visited: BooleanArray,
    from: Int
): Int {
    var change = 0
    visited[from] = true
    for (to in al[from]) if (!visited[abs(to)]) change += dfs(al, visited, abs(to)) + if (to > 0) 1 else 0
    return change
}

fun minReorder(
    n: Int,
    connections: Array<IntArray>
): Int {
    val al: Array<LinkedList<Int>> = Array(n) { LinkedList() }
    for (c in connections) {
        al[c[0]].add(c[1])
        al[c[1]].add(-c[0])
    }
    return dfs(al, BooleanArray(n), 0)
}