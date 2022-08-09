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

    val root1 = TreeNode(0).apply{
        left = TreeNode(0).apply {
            left = TreeNode(0)
            right = TreeNode(0)
        }
    }

    val root2 = TreeNode(0).apply{
        left = TreeNode(0).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0).apply {
                    right = TreeNode(0)
                }
            }
        }
    }

//    println(Solution().swapNodes(link,5))
    println(Solution().numFactoredBinaryTrees(intArrayOf(2,4)))
    println(Solution().numFactoredBinaryTrees(intArrayOf(2,4,5,10)))
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

class Solution {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val mod = 1_000_000_007
        val n = arr.size
        arr.sort()

        val dp = LongArray(n) { 1 }
        val index = HashMap<Int, Int>()

        for (i in 0 until n) index[arr[i]] = i

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (arr[i] % arr[j] == 0) {
                    val right = arr[i] / arr[j]
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index[right]!!]) % mod
                    }
                }
            }
        }

        var ans: Long = 0
        for (x in dp) ans += x
        return (ans % mod).toInt()
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
