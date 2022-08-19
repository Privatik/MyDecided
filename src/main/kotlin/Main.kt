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

    val firstGraph = Graph(
        root = 0,
        vertexs = listOf(
            Graph(
                root = 1,
                vertexs = listOf(
                    Graph(
                        root = 2
                    ),
                    Graph(
                        root = 3
                    )
                )
            ),
            Graph(
                root = 4
            )
        )
    )
//    val firstGraph

    println(Solution().isTree(firstGraph))
//
    val secondVertex = Graph(
        root = 0,
        vertexs = listOf(
            Graph(
                root = 1,
              ),
            Graph(
                root = 2,
                vertexs = listOf(
                    Graph(
                        root = 3,
                        vertexs = listOf(
                            Graph(
                                root = 1
                            )
                        )
                    ),
                    Graph(
                        root = 4,
                        vertexs = listOf(
                            Graph(
                                root = 0
                            )
                        )
                    )
                )
            )
        )
    )
//
    println(Solution().isTree(secondVertex))
//
    val thirdVertex = Graph(
        root = 0,
        vertexs = listOf(
            Graph(
                root = 1,
                vertexs = listOf(
                    Graph(
                        root = 2
                    )
                )
            ),
            Graph(
                root = 4
            )
        )
    )

    println(Solution().isTree(thirdVertex))

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

data class Graph(
    val root: Int,
    val vertexs: List<Graph> = emptyList()
)

class Solution {
    fun isTree(graph: Graph): Boolean{
        val isVisited = hashSetOf<Int>()
        val vertexQueue = LinkedList<Graph>()

        vertexQueue.add(graph)

        while (vertexQueue.size != 0){
            vertexQueue.removeFirst().apply {
                isVisited.add(root)
                vertexs.forEach {
                    if (isVisited.contains(it.root)){ return false }
                    vertexQueue.add(it)
                }
            }
        }
        return true
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
