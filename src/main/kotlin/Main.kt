import kotlin.collections.ArrayList


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


    println(Solution().canFinish(3, arrayOf(intArrayOf(2,0), intArrayOf(1,2))))
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
        val graph = Array<ArrayList<Int>>(numCourses) { arrayListOf() }
        val degree = IntArray(numCourses)
        val bfs = arrayListOf<Int>()

        /*
        5   [[1,4],[2,4],[3,1],[3,2]]


         */
        for (e in prerequisites) {
            graph[e[1]].add(e[0])
            degree[e[0]]++
        }

        for (i in 0 until numCourses) if (degree[i] == 0) bfs.add(i)
        for (i in bfs.indices) for (j in graph[bfs[i]]) if (--degree[j] == 0) bfs.add(j)
        return bfs.size == numCourses
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
