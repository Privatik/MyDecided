import java.util.*

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
        )
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
        )
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
        )
    )
}

fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {

}