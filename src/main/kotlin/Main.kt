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


    println((Solution().groupAnagrams(arrayOf("eeat","tea","tan","ate","nat","bat"))))
}

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val stringToOutputWords = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val freqMap = TreeMap<Char, Int>()

            str.toCharArray().forEach { c ->
                freqMap.merge(c, 1) { a: Int, b: Int -> a + b }
            }

            stringToOutputWords.computeIfAbsent(freqMap.toString()) { s: String? -> ArrayList() }

            stringToOutputWords[freqMap.toString()]!!.add(str)
        }

        return stringToOutputWords.values.toList()
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
