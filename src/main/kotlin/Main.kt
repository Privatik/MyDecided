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


    println(Solution().multiply("22","32"))

}

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val len1: Int = num1.length
        val len2: Int = num2.length
        val len = len1 + len2
        val product = IntArray(len)
        for (i in num1.length - 1 downTo 0) {
            val a: Int = num1[i] - '0'
            println("a - $a")
            for (j in num2.length - 1 downTo 0) {
                val b: Int = num2[j] - '0'
                val idx: Int = i + j + 1
                val p = a * b + product[idx]
                println("b - $b, i = $i. j = $j, p = $p")
                product[idx] = p % 10
                product[idx - 1] += p / 10
            }
        }

        val start = if (product[0] != 0) 0 else 1
        val result = StringBuilder()
        for (i in start until len) {
            print("${product[i]} ")
            result.append(product[i])
        }
        println()
        return result.toString()
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
