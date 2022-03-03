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


    println(Solution().numDecodings("106"))
}

class Solution {
    fun numDecodings(s: String): Int {
        var counter = 0
        val currentSte = StringBuilder()
        if (s[0] == '0') return 0
        s.forEach { number ->
            if (number != '0'){
                counter++
                currentSte.append(number)
            }
            if (currentSte.length > 1){
                if (isGetNumber(currentSte.toString().toInt())){
                    counter++
                }
                currentSte.deleteAt(0)
            }
        }

        return counter
    }

    fun isGetNumber(strNumber: Int): Boolean =
        when (strNumber){
            in 10..26 -> true
            else -> false
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
