import java.util.*
import kotlin.math.max

fun main() {


    println(
        longestSubarray(intArrayOf(1,1,0,1))
    )

    println(
        longestSubarray(intArrayOf(0,1,1,1,0,1,1,0,1))
    )

    println(
        longestSubarray(intArrayOf(1,1,1))
    )


}


fun longestSubarray(nums: IntArray): Int {
    var max = 0
    var canDeleteZeros = 1
    var start = 0

    var end = 0
    while (end < nums.size){
        if (nums[end] == 0){
            if (canDeleteZeros == 1){
                canDeleteZeros = 0
            } else {
                start++
                if (nums[start] == 1) { end-- }
            }
        }

        max = max(end - start, max)
        end++
    }

    return max
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







