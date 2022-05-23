import java.util.*

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


    val arrStr = arrayOf("10","0001","111001","1","0")
    val arrStr1 = arrayOf("10","0","1")
    println(Solution().findMaxForm(arrStr,4,3))
//    println(Solution().findMaxForm(arrStr1,1,1))
}


class Solution {

    private data class Element(
        val count: Int = 0,
        val m: Int = 0,
        val n: Int = 0
    )

    private val ZERO = '0'
    private val ONE = '1'

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val list: Queue<Element> = LinkedList<Element>()
        var step = strs.size - 1
        var cursor = 0

        repeat(strs.size){ index ->
            val (zero, one) = strs[index].toCharArray().partition { it == ZERO }
            list.add(Element(1, zero.size, one.size))
        }

        println(list)

        while (step != 0){
            val first = list.poll()
            val second = list.peek()

            val newM = first.m + second.m
            val newN = first.n + second.n
            if (newM > m || newN > n){
                list.add(Element())
            } else {
                list.add(
                    Element(
                        first.count + second.count,
                        newM,
                        newN
                    )
                )
            }
            cursor++
            if (step == cursor){
                list.poll()
                step--
                cursor = 0
                println("new step")
            }
            println(list)
        }

        println(list)

        return list.poll().count
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
