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

    val arr = arrayOf( intArrayOf(1,5,9), intArrayOf(10,11,13), intArrayOf(12,13,15) )
    val strArr = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val strArr2 = arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com")

    val headA1 = ListNode(4).apply {
        add(mutableListOf(1,8,4,5))
    }
    val headB1 = ListNode(5).apply {
        add(mutableListOf(6,1,8,4,5))
    }

    val headA2 = ListNode(1).apply {
        add(mutableListOf(9,1,2,4))
    }
    val headB2 = ListNode(3).apply {
        add(mutableListOf(2,4))
    }

    println(Solution().getIntersectionNode(headA1,headB1))
    println(Solution().getIntersectionNode(headA2,headB2))
}


class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var p1 = headA
        var p2 = headB

        var len1 = 0
        var len2 = 0

        while (p1 != null) {
            p1 = p1.next
            len1++
        }
        while (p2 != null) {
            p2 = p2.next
            len2++
        }

        p1 = headA
        p2 = headB
        if (len1 > len2) {
            for (i in 0 until len1 - len2) {
                p1 = p1!!.next
            }
        } else {
            for (i in 0 until len2 - len1) {
                p2 = p2!!.next
            }
        }
        while (p1 != p2) {
            p1 = p1!!.next
            p2 = p2!!.next
        }
        return p1
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
