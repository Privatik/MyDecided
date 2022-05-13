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
    val link = ListNode(1).apply {
        add(mutableListOf(2,3,4))
    }

    val link3 = ListNode(1)
    val link4 = ListNode(1).apply {
        add(mutableListOf(2,3,4,5))
    }
    val link5 = ListNode(1).apply {
        add(mutableListOf(2,3))
    }


    println(Solution().generateParenthesis(3))
}


class Solution {

    private data class Decision(
        val str: StringBuilder,
        val open: Int,
        val close: Int
    )

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<Decision>()
        val startDecision = Decision(StringBuilder(), 0, 0)
        result.add(startDecision)

        while (result.first().close != n){
            val count = result.size
            repeat(count){
                val current = result.removeAt(0)

                if (current.open < n){
                    val decision = Decision(StringBuilder(current.str).apply { append('(') }, current.open + 1, current.close)
                    result.add(decision)
                }

                if (current.close < current.open){
                    val decision = Decision(StringBuilder(current.str).apply { append(')') }, current.open, current.close + 1)
                    result.add(decision)
                }
            }
        }

        return result.map { it.str.toString() }
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
