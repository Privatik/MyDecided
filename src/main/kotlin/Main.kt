
import java.util.*


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
        predictPartyVictory("RD")
    )

    println(
        predictPartyVictory("RDD")
    )
}

//DA

fun predictPartyVictory(senate: String): String {
    val queue: Queue<Char> = LinkedList()

    senate.forEach { item -> queue.offer(item) }
    queue.offer('A')
    var isOnlyOneParties = true

    while (queue.size != 2){
        val value = queue.poll()
        var nextValue = queue.peek()
        queue.offer(value)

        if (nextValue == 'A') {
            if (isOnlyOneParties) { break }
            queue.poll()
            nextValue = queue.peek()
            queue.offer('A')
        }

        if (value != nextValue){
            isOnlyOneParties = false
            queue.poll()
        }
    }

    return if (queue.peek() == 'R') "Radiant" else "Dire"
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







