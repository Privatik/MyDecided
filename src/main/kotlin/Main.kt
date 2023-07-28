
import java.util.*
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.min


const val codeA = 1040

fun main() {
//    val counter = RecentCounter()
//
//    println(
//        counter.ping(1)
//    )
//
//    println(
//        counter.ping(100)
//    )
//
//    println(
//        counter.ping(3001)
//    )
//
//    println(
//        counter.ping(3002)
//    )

    println(
        maxProfit(intArrayOf(7,1,5,3,6,4))
    )

    println(
        maxProfit(intArrayOf(7,6,4,3,1))
    )

    println(
        maxProfit(intArrayOf(1,2,3))
    )

    println(
        maxProfit(intArrayOf(6,1,3,2,4,7))
    )
}

class RecentCounter() {
    private val queue: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.peek() < t - 3000){ queue.poll() }
        return queue.size
    }


}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var min = prices[0]

    (1 until prices.size).forEach { index ->
        min = min(min, prices[index])
        profit = max(prices[index] - min, profit)
    }

    return profit
}

//fun ListNode.getValues(): StringBuilder{
//    val builder = StringBuilder()
//    builder.append(`val`)
//    if (next != null){
//        builder.append(" ")
//        builder.append(next!!.getValues())
//    }
//    return builder
//}







