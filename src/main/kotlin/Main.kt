import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    println(
        countSubTrees(
            7,
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(0,2),
                intArrayOf(1,4),
                intArrayOf(1,5),
                intArrayOf(2,3),
                intArrayOf(2,6),
            ),
            "abaedcd"
        ).joinToString(" ")
    )

    println(
        countSubTrees(
            4,
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(1,2),
                intArrayOf(0,3),
            ),
            "bbbb"
        ).joinToString(" ")
    )


    println(
        countSubTrees(
            5,
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(0,2),
                intArrayOf(1,3),
                intArrayOf(0,4),
            ),
            "aabab"
        ).joinToString(" ")
    )

    println(
        countSubTrees(
            4,
            arrayOf(
                intArrayOf(0,2),
                intArrayOf(0,3),
                intArrayOf(1,2),
            ),
            "aabab"
        ).joinToString(" ")
    )
}

fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
    val result = IntArray(n) { 0 }
    val vectors = Array<LinkedList<Int>>(n) { LinkedList() }

    edges.forEach {
        vectors[it[0]].add(it[1])
        vectors[it[1]].add(it[0])
    }

    dfs(result, labels, vectors, 0, -1)

    return result
}

fun dfs(
    result: IntArray,
    label: String,
    vectors: Array<LinkedList<Int>>,
    currentIndex: Int,
    prevIndex: Int,
): HashMap<Char, Int> {
    val currentChar = label[currentIndex]
    val cache: HashMap<Char, Int> = hashMapOf()

    vectors[currentIndex].forEach { nextIndex ->
        if (nextIndex != prevIndex){
            val timeCache = dfs(result, label, vectors, nextIndex, currentIndex)

            timeCache.forEach { (c, i) ->
                cache[c] = cache.getOrDefault(c, 0) + i
            }
        }
    }

    cache[currentChar] = cache.getOrDefault(currentChar, 0) + 1
    result[currentIndex] = cache[currentChar]!!

    return cache
}