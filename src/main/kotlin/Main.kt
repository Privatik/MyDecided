import java.util.*
import kotlin.math.max

fun main() {


    println(largestAltitude(intArrayOf(-5,1,5,0,-7)))

    println(largestAltitude(intArrayOf(-4,-3,-2,-1,4,3,2)))

}


fun largestAltitude(gain: IntArray): Int {
    val prefixSum = IntArray(gain.size + 1)
    var max = 0

    repeat(gain.size) { index ->
        val value = prefixSum[index] + gain[index]
        prefixSum[index + 1] = value
        max = max(max, value)
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







