
import java.util.*
import kotlin.math.log10


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
    val dp = Array(prices.size) { IntArray(prices.size) { Int.MIN_VALUE } }

    dp[0][0] = 0

    if (prices.size > 1){
        if (prices[1] - prices[0] > 0){
            dp[0][1] = -prices[0]
        }
    }

    (1 until prices.size).forEach { firstIndex->
        (0..firstIndex).forEach { secondIndex ->
            val next = (dp[firstIndex - 1].getOrNull(secondIndex + 1) ?: Int.MIN_VALUE)

            dp[firstIndex][secondIndex] = maxOf(
                dp[firstIndex - 1][secondIndex],
                -prices[firstIndex] ,
                if (next <= 0) { next + prices[firstIndex] } else Int.MIN_VALUE
            )
        }
    }

    println("-------")
    println(
        dp.joinToString("\n") { it.joinToString(" ") }
    )
    println("-------")

    return dp.last().first()
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







