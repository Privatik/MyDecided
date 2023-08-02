
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
        deleteMiddle(
            createListNode(values = intArrayOf(1,3,4,7,1,2,6))
        )?.getValues()
    )

    println(
        deleteMiddle(
            createListNode(values = intArrayOf(1,2,3,4))
        )?.getValues()
    )

    println(
        deleteMiddle(
            createListNode(values = intArrayOf(2,1))
        )?.getValues()
    )
}

fun deleteMiddle(head: ListNode?): ListNode? {
    val preMiddleNode = findPreMiddle(0,0, head, null)
    preMiddleNode?.next = preMiddleNode?.next?.next
    return if (preMiddleNode == null) head?.next else head
}

private fun findPreMiddle(
    middleIndex: Int,
    currentSize: Int,
    head: ListNode?,
    currentPreMiddle: ListNode?,
): ListNode? {
    var nextPreMiddle: ListNode? = currentPreMiddle
    var _middleIndex = middleIndex

    if ((currentSize + 1) / 2 != middleIndex){
        nextPreMiddle = if (currentPreMiddle == null) head else currentPreMiddle.next
        _middleIndex++
    }

    if (head?.next != null){
        nextPreMiddle = findPreMiddle(_middleIndex,currentSize + 1, head.next, nextPreMiddle)
    }

    return nextPreMiddle
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createListNode(
    startIndex: Int = 0,
    values: IntArray,
): ListNode? {
    if (startIndex !in values.indices) return null
    val node = ListNode(values[startIndex])
    node.next = createListNode(startIndex + 1, values)
    return node
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







