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

//   println(Solution().validPath(3, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,0)),0, 2))
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
    println(Solution().findLexSmallestString("5525",9,2))
    println(Solution().findLexSmallestString("74",5,1))
    println(Solution().findLexSmallestString("0011",4,2))
//    println(Solution().hasPathSum(null, 0))
//    println(Solution().hasPathSum(root23, 1))
//   println(Solution().maximumTime("??:?0"))
//   println(Solution().maximumTime("0?:3?"))
//   println(Solution().maximumTime("1?:22"))
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

//[[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]]
//[[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]
//13
//10

class Solution {

    fun findLexSmallestString(
        currentLex: String,
        add: Int,
        rotate: Int
    ): String {
        val lexStack = LinkedList<String>()
        val cacheAnswers = hashSetOf<String>()

        var min = currentLex
        var next: String? = currentLex

        while (next != null){
            val addValue = add(next, add)
            val rotateValue = rotate(next, rotate)

            if (!cacheAnswers.contains(addValue)){
                min = min(min, addValue)
                lexStack.offer(addValue)
                cacheAnswers.add(addValue)
            }

            if (!cacheAnswers.contains(rotateValue)){
                min = min(min, rotateValue)
                lexStack.offer(rotateValue)
                cacheAnswers.add(rotateValue)
            }

            next = lexStack.poll()
        }
        return min
    }

    private fun add(currentLex: String, add: Int): String{
        val values = currentLex.toCharArray()
        values.indices.forEach { index ->
            if (index % 2 == 1){
                var newChar = values[index] + add
                if (newChar !in '0'..'9'){
                    newChar -= 10
                }
                values[index] = newChar
            }
        }

        return values.joinToString("")
    }


    private fun rotate(currentLex: String, rotate: Int): String{
        val values = CharArray(currentLex.length)
        var startIndex = currentLex.length - rotate
        values.indices.forEach {
            values[it] = currentLex[startIndex]

            startIndex++

            if (startIndex == currentLex.length){
                startIndex = 0
            }
        }
        return values.joinToString("")
    }

    private fun min(currentLex: String, lastMinLex: String): String{
        var isCurrentLexLeast: Boolean? = null
        var index = 0
        while (isCurrentLexLeast == null){
            if (index >= currentLex.length) return currentLex
            if (currentLex[index] == lastMinLex[index]) {
                index++
                continue
            }
            isCurrentLexLeast = currentLex[index] < lastMinLex[index]
        }
        return if (isCurrentLexLeast) currentLex else lastMinLex
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
