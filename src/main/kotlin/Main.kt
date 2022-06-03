import kotlin.math.abs

fun main(args: Array<String>) {

//    val head = Solution.TreeNode(3).also { root ->
//        root.left = TreeNode(1).also { left ->
//            left.right = TreeNode(2)
//        }
//    }
//
//    val head1 = TreeNode(1).also { root ->
//        root.left = TreeNode(2).also { left ->
//            left.right = TreeNode(3)
//        }
//
//        root.right = TreeNode(2).also { right ->
//            right.right = TreeNode(3)
//        }
//    }
//
//    val head2 = TreeNode(2).also { root ->
//        root.left = TreeNode(3).also { left ->
//            left.left = TreeNode(4)
//            left.right = TreeNode(5)
//        }
//
//        root.right = TreeNode(3).also { right ->
//            right.left = TreeNode(5)
//        }
//    }
//
    val link = ListNode(1).apply {
        add(mutableListOf(2,3,4))
    }

    val link3 = ListNode(1)
    val link4 = ListNode(1).apply {
        add(mutableListOf(2,3,4,5))
    }
    val link5 = ListNode(1).apply {
        add(mutableListOf(2,3))
    }

    val arr = arrayOf( intArrayOf(1,5,9), intArrayOf(10,11,13), intArrayOf(12,13,15) )
    val strArr = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val strArr2 = arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com")

    val array = arrayOf(
        intArrayOf(3, 0, 1, 4, 2),
        intArrayOf(5, 6, 3, 2, 1),
        intArrayOf(1, 2, 0, 1, 5),
        intArrayOf(4, 1, 0, 1, 7),
        intArrayOf(1, 0, 3, 0, 5)
    )

    array.forEach {
        println(it.joinToString(" "))
    }
    println("-------")
    val numMatrix = NumMatrix(array)
    println(numMatrix.sumRegion(2,1,4,3))
    println(numMatrix.sumRegion(1,1,2,2))
    println(numMatrix.sumRegion(1,2,2,4))
}


class Solution {

}

class NumMatrix(matrix: Array<IntArray>) {

    val acc = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) }

    init {
        for (i in matrix.indices) {
            var rowSum = 0
            for (j in 0 until matrix[0].size) {
                rowSum += matrix.at(i, j)
                acc[i][j] = rowSum + acc.at(i - 1, j)
            }
        }

        println("------")
        acc.forEach {
            println(it.joinToString(" "))
        }
        println("------")
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return acc[row2][col2] - acc.at(row1 - 1, col2) - acc.at(row2, col1 - 1) + acc.at(row1 - 1, col1 - 1)
    }

    fun Array<IntArray>.at(i: Int, j: Int): Int {
        if(i < 0 || i >= size || j < 0 || j >= this[0].size) return 0

        return this[i][j]
    }

}


class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun add(list: MutableList<Int>){
        val l = list.removeAt(0)
        next = ListNode(l).also {
            if (list.isNotEmpty()){
                it.add(list)
            }
        }
    }

    override fun toString(): String {
        return "$`val` ${next.toString()}"
    }
}
//
//
//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//
//    override fun toString(): String {
//        return `val`.toString()
//    }
//}
