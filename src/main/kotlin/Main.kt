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


    println(Solution().combine(4,2))
}

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val listCombine = mutableListOf<List<Int>>()
        val count = countCombinations(n,k)
        repeat(count){ indexCombine ->
            repeat(k){ indexInCouple ->
                listCombine.add()
            }
        }
        return emptyList()
    }

    private fun currentList(start: Int, endIndex: Int): List<Int> {

        return emptyList()
    }

    private fun countCombinations(n: Int, k: Int): Int {
        return factorial(n)/(factorial(k) * factorial(n - k))
    }

    private fun factorial(n: Int): Int {
        if (n == 1) return n
        return n * factorial(n - 1)
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
