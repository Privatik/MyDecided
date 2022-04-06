import kotlin.math.max

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
//        add(mutableListOf(4,3,2,5,2))
//    }


    println(Solution().jump(intArrayOf(2,3,1,1,4)))
}


class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var curEnd = 0
        var curFarthest = 0
        for (i in nums.indices) {
            curFarthest = max(curFarthest, i + nums[i])
            if (i == curEnd) {
                jumps++
                curEnd = curFarthest
            }
        }
        return jumps
    }
}


//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//
//    fun add(list: MutableList<Int>){
//        val l = list.removeAt(0)
//        next = ListNode(l).also {
//            if (list.isNotEmpty()){
//                it.add(list)
//            }
//        }
//    }
//
//    override fun toString(): String {
//        return "$`val` ${next.toString()}"
//    }
//}
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
