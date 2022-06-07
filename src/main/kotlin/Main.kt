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

    val num1 = intArrayOf(1,2,3,0,0,0)
    val num2 = intArrayOf(2,5,6)
    Solution().merge(num1, 3, num2, 3)
    println(num1.joinToString(" "))

    val num3 = intArrayOf(1)
    val num4 = intArrayOf()
    Solution().merge(num3, 1, num4, 0)
    println(num3.joinToString(" "))

    val num5 = intArrayOf(0)
    val num6 = intArrayOf(1)
    Solution().merge(num5, 0, num6, 1)
    println(num5.joinToString(" "))

    val num7 = intArrayOf(2,0)
    val num8 = intArrayOf(1)
    Solution().merge(num7, 1, num8, 1)
    println(num7.joinToString(" "))
}


class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (n == 0) return
        if (m == 0){
            for (i in nums1.indices){
                nums1[i] = nums2[i]
            }
        }

        var point1 = 0
        var point2 = 0

        val answer = IntArray(nums1.size)

        while (answer.size > point1 + point2){
            val index = point1 + point2

            val isMore = nums1[point1] > nums2[point2]
            val min = if (isMore){
                nums2[point2]
            } else {
                nums1[point1]
            }

            answer[index] = min

            if (isMore){
                point2 = if (point2 + 1 < n - 1) point2 + 1 else n - 1
            } else {
                point1 = if (point1 + 1 < m - 1) point1 + 1 else m - 1
            }
        }

        for (i in nums1.indices){
            nums1[i] = answer[i]
        }
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
