import java.util.*


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

    val link = ListNode(1).apply {
        add(mutableListOf(4,3,2,5,2))
    }


    println(Solution().searchMatrix(
        matrix = arrayOf(intArrayOf(1,3,5,6), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)),
        target = 3
    ))
}

/*

  List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;


 */

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var currentPosition = -1

        for(index in matrix.indices) {
            val currentRow = matrix[index]
            if (currentRow.last() >= target && target >= currentRow.first()){
                if (currentRow.last() == target || currentRow.first() == target) return true
                currentPosition = index
                break
            }
        }

        return if (currentPosition == -1) false else isHasValue(matrix[currentPosition], target)
    }

    private fun isHasValue(row: IntArray, target: Int): Boolean{
        var l = 0
        var r = row.lastIndex

        while (l < r){
            val m = (l + r) / 2
            if (row[m] >= target){
                r = m
            } else {
                l = m + 1
            }
        }

        return target == row[l]
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
