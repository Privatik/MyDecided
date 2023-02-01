import java.util.*
import kotlin.math.min


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
//    val link = ListNode(1).apply {
//        add(mutableListOf(2,3,4,5))
//    }
//
//    val link3 = ListNode(1)
//    val link4 = ListNode(1).apply {
//        add(mutableListOf(2))
//    }
//    val link5 = ListNode(7).apply {
//        add(mutableListOf(9,6,6,7,8,3,0,9,5))
//    }
//
//    val arr = arrayOf( intArrayOf(1,5,9), intArrayOf(10,11,13), intArrayOf(12,13,15) )
//    val strArr = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
//    val strArr2 = arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com")
//
//    val str1 = "babad"
//    val str2 = "cbbd"
//
//    val root1 = TreeNode(2).apply{
//        left = TreeNode(1)
//        right = TreeNode(3)
//    }
//
//    val root2 = TreeNode(5).apply{
//        left = TreeNode(1)
//        right = TreeNode(4).apply {
//            left = TreeNode(3)
//            right = TreeNode(6)
//        }
//    }

//    println(Solution().swapNodes(link,5))
//    println(Solution().numFactoredBinaryTrees(intArrayOf(2,4)))

//    println(Solution().maximumImportance(5,
//        arrayOf(
//            intArrayOf(0,1),
//            intArrayOf(1,2),
//            intArrayOf(2,3),
//            intArrayOf(0,2),
//            intArrayOf(1,3),
//            intArrayOf(2,4)
//        )
//    ))

//    println(Solution().longestSubarray(intArrayOf(1,1,0,1)))
//    println(Solution().partition("gagga"))
//    println(Solution().partition("a"))
//    println(Solution().distributeCookies(intArrayOf(8,15,10,20,8), 2))
//    println(Solution().maxCompatibilitySum(
//        arrayOf(
//            intArrayOf(1,1,0),
//            intArrayOf(1,0,1),
//            intArrayOf(0,0,1)
//        ),
//        arrayOf(
//            intArrayOf(1,0,0),
//            intArrayOf(0,0,1),
//            intArrayOf(1,1,0)
//        )
//    ))

//    println(Solution().maxCompatibilitySum(
//        arrayOf(
//            intArrayOf(0,0),
//            intArrayOf(0,0),
//            intArrayOf(0,0)
//        ),
//        arrayOf(
//            intArrayOf(1,1),
//            intArrayOf(1,1),
//            intArrayOf(1,1)
//        )
//    ))

//    println(Solution().maxCompatibilitySum(
//        arrayOf(
//            intArrayOf(0,1,0,1,1,1),
//            intArrayOf(1,0,0,1,0,1),
//            intArrayOf(1,0,1,1,0,0)
//        ),
//        arrayOf(
//            intArrayOf(1,0,0,0,0,1),
//            intArrayOf(0,1,0,0,1,1),
//            intArrayOf(0,1,0,0,1,1)
//        )
//    ))

    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
        }
        right = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }

    val root2 = TreeNode(1).apply {
        left = TreeNode(3).apply {
            left = TreeNode(3)
            right = TreeNode(2)
        }
        right = TreeNode(3)
    }

    val root23 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2).apply {
                left = TreeNode(2)
            }
        }
    }

//    println(String(byteArrayOf(73,32,119,97,110,116,32,116,111,32,98,101,108,105,101,118,101)))

   println(Solution().minScoreTriangulation(intArrayOf(3,7,4,5)))
//   println(Solution().validPath(6, arrayOf(intArrayOf(0,1),intArrayOf(0,2),intArrayOf(3,5),intArrayOf(5,4),intArrayOf(4,3)),0, 5))
//   println(Solution().validPath(
//       10,
//       arrayOf(
//           intArrayOf(0,7),
//           intArrayOf(0,8),
//           intArrayOf(6,1),
//           intArrayOf(2,0),
//           intArrayOf(0,4),
//           intArrayOf(5,8),
//           intArrayOf(4,7),
//           intArrayOf(1,3),
//           intArrayOf(3,5),
//           intArrayOf(6,5),
//       ),
//       7,
//       5
//   ))
//    println(Solution().deepestLeavesSum(root1))
//    println(Solution().removeLeafNodes(root1, 2))
//    println(Solution().removeLeafNodes(root2, 3))
//    println(Solution().getOrder(
//        arrayOf(
//            intArrayOf(1,2),
//            intArrayOf(2,4),
//            intArrayOf(3,2),
//            intArrayOf(4,1),
//        )
//    ).joinToString(" "))
//    println(Solution().getOrder(
//        arrayOf(
//            intArrayOf(7,10),
//            intArrayOf(7,12),
//            intArrayOf(7,5),
//            intArrayOf(7,4),
//            intArrayOf(7,2),
//        )
//    ).joinToString(" "))
//    println(Solution().getOrder(
//        arrayOf(
//            intArrayOf(19,13),
//            intArrayOf(16,9),
//            intArrayOf(21,10),
//            intArrayOf(32,25),
//            intArrayOf(37,4),
//            intArrayOf(49,123),
//            intArrayOf(2,15),
//            intArrayOf(38,41),
//            intArrayOf(37,34),
//            intArrayOf(33,6),
//            intArrayOf(45,4),
//            intArrayOf(18,18),
//            intArrayOf(46,39),
//            intArrayOf(12,24),
//        )
//    ).joinToString(" "))
//    println(Solution().hasPathSum(null, 0))
//    println(Solution().hasPathSum(root23, 1))
//   println(Solution().maximumTime("??:?0"))
//   println(Solution().maximumTime("0?:3?"))
////   println(Solution().maximumTime("1?:22"))
//    println(Solution().pushDominoes(".L.R...LR..L.."))
//    println(Solution().pushDominoes("RR.L"))
//    println(Solution().swapNodes(link,1))
//    println(Solution().lengthOfLIS(intArrayOf(7,7,7,7,7,7,7)))

//    println(Solution().longestPalindrome(str1))
//    println(Solution().longestPalindrome(str2))
//    println(Solution().lengthOfLongestSubstring(str4))
//    println(Solution().lengthOfLongestSubstring(str5))
//    println(Solution().lengthOfLongestSubstring(str6))
}

//[[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]]
//[[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]
//13
//10


//1,2,3,0,2
class Solution {
    private val r = 'R'
    private val l = 'L'
    private val dot = '.'
    private val q = '?'

    fun minScoreTriangulation(values: IntArray): Int {
        val n: Int = values.size
        val dp = Array(n) { IntArray(n) }
        for (d in 2 until n) {
            dp.print()
            var i = 0
            while (i + d < n) {
                val j = i + d
                dp[i][j] = Int.MAX_VALUE
                for (k in i + 1 until j) {
                    println("---------")
                    println("var i = $i j = $j d = $d k = $k")
                    println("---------")
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k])
                    dp.print()
                }
                ++i
            }
        }
        return dp[0][n - 1]
    }

    private fun Array<IntArray>.print(){
        println("---------")
        forEach {
            println(it.joinToString(" "))
        }
        println("---------")
    }

}

class UnionFind(private val nodes: IntArray) {

    private var components: Int = nodes.size

    fun find(x: Int): Int {
        return if (x == nodes[x]) x else find(nodes[x])
    }

    fun unify(x: Int, y: Int) {
        val root1 = find(x)
        val root2 = find(y)

        if (root1 == root2) return

        nodes[root2] = root1
        components--
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



//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//}



class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "$`val` $left $right"
    }
}
