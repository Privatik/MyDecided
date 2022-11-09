import kotlin.math.max
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

    val root1 = TreeNode(2).apply {
        left = TreeNode(2)
        right = TreeNode(5).apply {
            left = TreeNode(5)
            right = TreeNode(7)
        }
    }

    val root2 = TreeNode(2).apply {
        left = TreeNode(2)
        right = TreeNode(2)
    }

   println(Solution().findSecondMinimumValue(root1))
   println(Solution().findSecondMinimumValue(root2))
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
    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root?.left == null) return -1
        val firstMin = root.`val`
        val answer = max(helper(firstMin , root.left!!), helper(firstMin, root.right!!))

        return if (firstMin == answer) -1 else answer
    }

    private fun helper(firstMin: Int, root: TreeNode): Int{
        if (root.left == null || root.`val` != firstMin) return root.`val`

        val nextMin = max(root.left!!.`val`, root.right!!.`val`)
        if (nextMin != firstMin) return nextMin

        return max(helper(firstMin , root.left!!), helper(firstMin, root.right!!))
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
        return `val`.toString()
    }
}
