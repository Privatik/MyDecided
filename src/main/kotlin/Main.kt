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


    println(Solution().intToRoman(2000))

}

class Solution {
    fun intToRoman(num: Int): String {
        return buildString {
            var number = num
            while (number >= 1000) {
                number -= 1000
                append('M')
            }

            when (number) {
                in 900..999 -> {
                    number -= 900
                    append("CM")
                }
                in 500..899 -> {
                    number -= 500
                    append("D")
                    while (number >= 100) {
                        number -= 100
                        append('C')
                    }
                }
                in 400..499 -> {
                    number -= 400
                    append("CD")
                }
                else -> {
                    while (number >= 100) {
                        number -= 100
                        append('C')
                    }
                }
            }

            when (number) {
                in 90..99 -> {
                    number -= 90
                    append("XC")
                }
                in 50..89 -> {
                    number -= 50
                    append("L")
                    while (number >= 10) {
                        number -= 10
                        append('X')
                    }
                }
                in 40..49 -> {
                    number -= 40
                    append("XL")
                }
                else -> {
                    while (number >= 10) {
                        number -= 10
                        append('X')
                    }
                }
            }

            when (number) {
                9 -> {
                    number -= 9
                    append("IX")
                }
                in 5..8 -> {
                    number -= 5
                    append("V")
                    while (number >= 1) {
                        number -= 1
                        append('I')
                    }
                }
                4 -> {
                    number -= 4
                    append("IV")
                }
                else -> {
                    while (number >= 1) {
                        number -= 1
                        append('I')
                    }
                }
            }
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
