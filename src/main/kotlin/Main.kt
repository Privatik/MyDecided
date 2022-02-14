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


    println(Solution().intToRoman(58))

}

class Solution {
    val romanMap = HashMap<Int, String>().apply {
        put(1,"I")
        put(4,"IV")
        put(5,"V")
        put(9,"IX")
        put(10,"X")
        put(40,"XL")
        put(50,"L")
        put(90,"XC")
        put(100,"C")
        put(400,"CD")
        put(500,"D")
        put(900,"CM")
        put(1000,"M")
    }

    val tensMap = HashMap<Int, Int>().apply{
        put(0,1)
        put(1,10)
        put(2,100)
        put(3,1000)
    }

    fun intToRoman(num: Int): String = buildString{
        var currentNum = num
        val count = num.toString().length

        repeat(count) { index ->
            val numForAdding = currentNum % 10
            currentNum /= 10
            append(getRomanNumber(numForAdding * tensMap[index]!!))
        }
        reverse()
    }

    private fun getRomanNumber(num: Int): String{
        return when(num){
            in 1 until 4 -> getCurrentNum(1, num)
            in 5 until 9 -> getCurrentNum(5, num)
            in 10 until 40 -> getCurrentNum(10, num/10)
            in 50 until 90 -> getCurrentNum(50, num/10)
            in 100 until 400 -> getCurrentNum(100, num/100)
            in 500 until 900 -> getCurrentNum(500, num/100)
            else -> romanMap[num]!!
        }
    }

    private fun getCurrentNum(key: Int, count: Int): String = buildString{
        repeat(count){
            append(romanMap[key])
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
