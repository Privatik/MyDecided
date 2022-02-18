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


    println((Solution().searchRange(intArrayOf(5,7,7,8,8),8)).joinToString(" "))
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1

        if (nums.isEmpty() || nums[left] > target || nums[right] < target) {
            return intArrayOf(-1, -1)
        }

        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) left = mid + 1
            else if (nums[mid] > target) right = mid - 1
            else right = mid
        }

        if (nums[left] != target) {
            return intArrayOf(-1, -1)
        }

        val leftBound = left

        right = nums.size - 1


        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) left = mid + 1
            else right = mid
        }

        val rightBound = if (nums[left] == target) left else left - 1

        return intArrayOf(leftBound, rightBound)
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
