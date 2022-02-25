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


    println(Solution().partition(link,4).toString())
}

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val lessList = HeadAndCurr()
        val geList = HeadAndCurr()

        var curr = head
        while (curr != null) {
            (if (curr.`val` < x) lessList else geList).append(curr)
            curr = curr.next
        }

        lessList.curr?.next = null
        geList.curr?.next = null
        return lessList.curr?.let { lessListCurr ->
            lessListCurr.next = geList.head
            lessList.head
        } ?: geList.head
    }

    private data class HeadAndCurr(var head: ListNode? = null, var curr: ListNode? = null) {
        inline fun append(node: ListNode) {
            if (curr == null) {
                head = node
            } else {
                curr!!.next = node
            }
            curr = node
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


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}
