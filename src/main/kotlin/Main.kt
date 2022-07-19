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

    println(Solution().minSubArrayLen(7,intArrayOf(2,3,1,2,4,3)))
    println(Solution().minSubArrayLen(4,intArrayOf(1,4,4)))
    println(Solution().minSubArrayLen(11,intArrayOf(1,1,1,1,1,1,1,1)))
    println(Solution().minSubArrayLen(5,intArrayOf(2,3,1,1,1,1,1)))

//    println(Solution().longestPalindrome(str1))
//    println(Solution().longestPalindrome(str2))
//    println(Solution().lengthOfLongestSubstring(str4))
//    println(Solution().lengthOfLongestSubstring(str5))
//    println(Solution().lengthOfLongestSubstring(str6))
}

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var res = nums.size + 1
        var curr = 0
        for (i in nums.indices) {
            curr += nums[i]
            if (curr < target) {
                continue
            }
            while (curr >= target) {
                curr -= nums[l++]
            }
            curr += nums[--l]
            res = minOf(res, i - l + 1)
        }
        return if (res == nums.size + 1) 0 else res
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
