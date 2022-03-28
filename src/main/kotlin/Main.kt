import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.system.measureTimeMillis


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


    println(Solution().canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
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

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val set = HashMap<Int,Item>()

        var couunt = 0
        while (couunt < prerequisites.size){
            val arr = prerequisites[couunt]
            if (arr[1] == set)
            val currentItem = Item(arr[1])
            val nextItem = Item(arr[0])
            currentItem.nextItems.add(nextItem)
            set.add(currentItem)
            set.add(nextItem)
            couunt++
        }

        return true
    }

    private data class Item(
        val courseCourse: Int,
        val nextItems: MutableList<Item> = mutableListOf()

    )
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
