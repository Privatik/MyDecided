fun main(args: Array<String>) {
//    println(
//        searchMatrix(
//            arrayOf(
//                intArrayOf(1,3),
//            ),
//            2
//        )
//    )


    println(
        searchMatrix(
            arrayOf(
                intArrayOf(1,3,5,7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,60),
            ),
            3
        )
    )

    println(
        searchMatrix(
            arrayOf(
                intArrayOf(1,3,5,7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,60),
            ),
            13
        )
    )

    println(
        searchMatrix(
            arrayOf(
                intArrayOf(1),
            ),
            2
        )
    )



}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val columns = matrix[0].size

    var left = 0
    var right = rows * columns - 1

    while (left <= right) {
        val middle = (right - left) / 2 + left
        val middleValue = matrix[middle/columns][middle%columns]
        if (middleValue == target) return true

        if (middleValue > target) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }

    return false
}








