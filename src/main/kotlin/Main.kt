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

    println(Solution().divide(10,3))
    println(Solution().divide(7,-3))
    println(Solution().divide(Int.MIN_VALUE,-1))

//    println(Solution().findMaxForm(arrStr1,1,1))
}


class Solution {

    fun divide(dividend: Int, divisor: Int): Int {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        var sign = 1
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1
        val ldividend = Math.abs(dividend.toLong())
        val ldivisor = Math.abs(divisor.toLong())

        //Take care the edge cases.
        if (ldivisor == 0L) return Int.MAX_VALUE
        if (ldividend == 0L || ldividend < ldivisor) return 0
        val lans = ldivide(ldividend, ldivisor)
        val ans: Int
        ans = if (lans > Int.MAX_VALUE) { //Handle overflow.
            if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        } else {
            (sign * lans).toInt()
        }
        return ans
    }

    private fun ldivide(ldividend: Long, ldivisor: Long): Long {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        var sum = ldivisor
        var multiple: Long = 1
        while (sum + sum <= ldividend) {
            sum += sum
            multiple += multiple
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor)
    }

//    fun divide(dividend: Int, divisor: Int): Int {
//        var result = 0
//        var sub = 1
//        var sum = 0
//
//        if (dividend == 0) return 0
//
//        val positiveDividend = if (dividend < 0) {
//            sub = -sub
//            if (dividend == Int.MIN_VALUE) -(dividend + 1) else -dividend
//        } else dividend
//
//        val positiveDivisor = if (divisor < 0) {
//            sub = -sub
//            -divisor
//        } else divisor
//
//        println("divisor $positiveDivisor dividend ${dividend < 0} $positiveDividend $sub")
//
//        println("-$sum")
//        while (sum + positiveDivisor <= positiveDividend){
//            if (sum + positiveDivisor < 0) {
//                result = if (sub < 0) Int.MIN_VALUE else Int.MAX_VALUE
//                break
//            }
//            sum += positiveDivisor
//            println("-next $sum")
//            result++
//        }
//
//        return result * sub
//    }
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
