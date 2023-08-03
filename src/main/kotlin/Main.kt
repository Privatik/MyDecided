
import java.util.*
import kotlin.math.min


const val codeA = 1040

fun main() {

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
    if (head?.next == null) return null
    val preMiddleItem = findPreMiddle(0,0, head.next, head)
    preMiddleItem?.next = preMiddleItem?.next?.next
    return head
}

private fun findPreMiddle(
    middleIndex: Int,
    currentSize: Int,
    head: ListNode?,
    currentPreMiddle: ListNode?,
): ListNode? {
    var nextPreMiddle: ListNode? = currentPreMiddle
    var _middleIndex = middleIndex

    if ((currentSize)/ 2 != middleIndex){
        nextPreMiddle = currentPreMiddle?.next
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







