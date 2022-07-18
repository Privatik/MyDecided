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

//    println(Solution().longestPalindrome(str1))
//    println(Solution().longestPalindrome(str2))
//    println(Solution().lengthOfLongestSubstring(str4))
//    println(Solution().lengthOfLongestSubstring(str5))
//    println(Solution().lengthOfLongestSubstring(str6))
}

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.size == 1) return if (nums[0] >= target) 1 else 0

        var result = nums.size
        val sumArr = IntArray(nums.size)

        // 2 5 6 8 12 15
        nums.forEachIndexed { index, i ->
            sumArr[index] = if (index == 0){
                i
            } else {
                i + sumArr[index - 1]
            }
        }

        if (sumArr.last() > target) return 0

        var min = 0
        var max = 1

        while (min != max){
            if (sumArr[max] - sumArr[min] >= target){
                val diff = max - min
                if (diff < result){
                    result = diff
                }
                min++
            } else {
                if (max != nums.lastIndex){
                    max++
                }
            }
        }

        return result


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
