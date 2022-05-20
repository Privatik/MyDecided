import java.util.*

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

    val arrmas = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(0,0,0))
    val arrmas2 = arrayOf(intArrayOf(0,1), intArrayOf(0,0))
    val arrmas3 = arrayOf(intArrayOf(0,0), intArrayOf(0,1))
    val arrmas4 = arrayOf(intArrayOf(1))
    val arrmas5 = arrayOf(intArrayOf(0))
    val arrmas6 = arrayOf(intArrayOf(1,0), intArrayOf(0,1))
    println(Solution().uniquePathsWithObstacles(arrmas))
    println(Solution().uniquePathsWithObstacles(arrmas2))
    println(Solution().uniquePathsWithObstacles(arrmas3))
    println(Solution().uniquePathsWithObstacles(arrmas4))
    println(Solution().uniquePathsWithObstacles(arrmas5))
    println(Solution().uniquePathsWithObstacles(arrmas6))
}


class Solution {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size

        val dp = ArrayList<IntArray>()

        val firstLine = IntArray(n) { 0 }

        firstLine[0] = if (obstacleGrid[0][0] == 0) 1 else 0

        for (i in 1 until n) {
            firstLine[i] = if (obstacleGrid[0][i] == 1) 0 else firstLine[i-1]
        }
        dp.add(firstLine)

        for (i in 1 until m) {
            dp.add(IntArray(n) { 0 })
        }

        for (i in 1 until m) {
            dp[i][0] = if (obstacleGrid[i][0] == 1) 0 else dp[i-1][0]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else dp[i-1][j] + dp[i][j-1]
            }
        }

        return dp[m-1][n-1]
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
