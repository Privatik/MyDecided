import java.util.*

fun main(args: Array<String>) {

    println(
        maxOperations(intArrayOf(1,2,3,4), 5)
    )

    println(
        maxOperations(intArrayOf(3,1,3,4,3), 6)
    )


}

fun maxOperations(nums: IntArray, k: Int): Int {
    nums.sort()

    var l = 0
    var r = nums.lastIndex

    var maxOperations = 0

    while (l < r){
        val left = nums[l]
        val right = nums[r]

        if (left + right == k){
            maxOperations++
            l++
            r--
        } else if (right + left < k){
            l++
        } else {
            r--
        }
    }

    return maxOperations
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun add(list: LinkedList<Int>){
        if (list.isNotEmpty()){
            next = ListNode(list.removeFirst()).also { it.add(list) }
        }
    }

}

fun ListNode.getValues(): StringBuilder{
    val builder = StringBuilder()
    builder.append(`val`)
    if (next != null){
        builder.append(" ")
        builder.append(next!!.getValues())
    }
    return builder
}







