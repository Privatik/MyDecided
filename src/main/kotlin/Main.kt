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

    val str1 = "abcabcbb"
    val str2 = "bbbbb"
    val str3 = "pwwkew"
    val str4 = "aab"
    val str5 = "dvdf"
    val str6 = "tmmzuxt"
    println(Solution().lengthOfLongestSubstring(str1))
//    println(Solution().lengthOfLongestSubstring(str2))
//    println(Solution().lengthOfLongestSubstring(str3))
//    println(Solution().lengthOfLongestSubstring(str4))
//    println(Solution().lengthOfLongestSubstring(str5))
//    println(Solution().lengthOfLongestSubstring(str6))
}


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val use = hashMapOf<Char, Int>()
        var max = 0
        var preMax = 0
        var startIndex = 1

        s.forEachIndexed { index, c ->
            val oldIndex = use[c]
            println("symbol = $c index = $index oldIndex = $oldIndex  preMAx = $preMax max =$max startIndex = $startIndex")
            if (oldIndex != null){
                preMax -= oldIndex
                startIndex = index + 1
            }
            if (++preMax > max){
                max = preMax
            }
            use[c] = index + 1
        }

        return max
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
