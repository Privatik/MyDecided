fun main(args: Array<String>) {

    val head = TreeNode(3).also { root ->
        root.left = TreeNode(1).also { left ->
            left.right = TreeNode(2)
        }
    }

    val head1 = TreeNode(1).also { root ->
        root.left = TreeNode(2).also { left ->
            left.right = TreeNode(3)
        }

        root.right = TreeNode(2).also { right ->
            right.right = TreeNode(3)
        }
    }

    val head2 = TreeNode(2).also { root ->
        root.left = TreeNode(3).also { left ->
            left.left = TreeNode(4)
            left.right = TreeNode(5)
        }

        root.right = TreeNode(3).also { right ->
            right.left = TreeNode(5)
        }
    }


    println((Solution().searchRange(intArrayOf(1, 4),4)).joinToString(" "))
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size < 2){
           if (nums.isEmpty()) return intArrayOf(-1,-1)
        }
        var l = 0
        var r = nums.size - 1
        while (l < r){
            val m = (l + r) / 2
            if (nums[m] >= target){
                r = m
            } else {
                l = m + 1
            }
        }
        val startPoint = if (nums[l] == target) l else -1

        l = 0
        r = nums.size - 1
        while (l < r){
            val m = (l + r) / 2
            if (nums[m] > target){
                r = m
            } else {
                l = m + 1
            }
        }
        val endPoint = if (nums[l - 1] == target) {
            if (nums.last() == target) l else l - 1
        } else -1

        return intArrayOf(startPoint,endPoint)
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

    override fun toString(): String {
        return `val`.toString()
    }
}
