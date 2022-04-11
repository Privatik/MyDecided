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


    println(Solution().checkSubarraySum(intArrayOf(23,2,6,4,7),6))
}


class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        nums.sort()


        var prefix = 1

        val currentMap = hashMapOf<Int, Int>()
        currentMap[0] = nums[0]

        while (prefix != nums.size){
            currentMap[0] +=
        }

        return true
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
