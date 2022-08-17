import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet


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
        add(mutableListOf(2,3,4,5))
    }

    val link3 = ListNode(1)
    val link4 = ListNode(1).apply {
        add(mutableListOf(2))
    }
    val link5 = ListNode(7).apply {
        add(mutableListOf(9,6,6,7,8,3,0,9,5))
    }

    val arr = arrayOf( intArrayOf(1,5,9), intArrayOf(10,11,13), intArrayOf(12,13,15) )
    val strArr = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val strArr2 = arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com")

    val str1 = "babad"
    val str2 = "cbbd"

    val root1 = TreeNode(2).apply{
        left = TreeNode(1)
        right = TreeNode(3)
    }

    val root2 = TreeNode(5).apply{
        left = TreeNode(1)
        right = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(6)
        }
    }

//    println(Solution().swapNodes(link,5))
//    println(Solution().numFactoredBinaryTrees(intArrayOf(2,4)))

    val firstVertex = hashMapOf(
        0 to Vertex(
            hashMapOf(1 to 5, 2 to 2),
        ),
        1 to Vertex(
            hashMapOf(3 to 4, 4 to 2),
        )
        2 to Vertex(
            hashMapOf(1 to 8, 4 to 7),
        ),
        3 to Vertex(
            hashMapOf(4 to 6, 5 to 8),
        ),
        4 to Vertex(
            hashMapOf(5 to 1),
        ),
        5 to Vertex(
            hashMapOf(),
        )
    )
//    val firstGraph

    println(Solution().findShortWay(
        Graph(firstVertex),0,5
    ))
//    println(Solution().lengthOfLIS(intArrayOf(0,1,0,3,2,3)))
//    println(Solution().swapNodes(link,3))
//    println(Solution().swapNodes(link,2))
//    println(Solution().swapNodes(link,1))
//    println(Solution().lengthOfLIS(intArrayOf(7,7,7,7,7,7,7)))

//    println(Solution().longestPalindrome(str1))
//    println(Solution().longestPalindrome(str2))
//    println(Solution().lengthOfLongestSubstring(str4))
//    println(Solution().lengthOfLongestSubstring(str5))
//    println(Solution().lengthOfLongestSubstring(str6))
}

data class Vertex(
    val ways: Map<Int, Int>
)

data class Graph(
    val vertexs: Map<Int, Vertex>
)

class Solution {
    fun findShortWay(
        graph: Graph,
        startPoint: Int,
        finishPoint: Int
    ): Int{
        val parentMap = hashMapOf<Int, Int>()
        val shortWayMap = hashMapOf<Int, Int>()
        val visitedMap = hashMapOf<Int, Boolean>()
        val nextPointForHandle = LinkedList<Int>()

        visitedMap[startPoint] = true
        graph.vertexs[startPoint]!!.ways.forEach { (point, length) ->
            nextPointForHandle.add(point)
            shortWayMap[point] = length
            parentMap[point] = startPoint
        }

        var visitedPoint = 1
        while (visitedPoint != graph.vertexs.size){
            val vertex = nextPointForHandle.removeFirst()
        }

        return 0
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



class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
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
