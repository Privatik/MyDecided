
import java.util.*
import kotlin.math.min


const val codeA = 1040

fun main() {

//    println(
//        deleteMiddle(
//            createListNode(values = intArrayOf(1,3,4,7,1,2,6))
//        )?.getValues()
//    )
//
//    println(
//        deleteMiddle(
//            createListNode(values = intArrayOf(1,2,3,4))
//        )?.getValues()
//    )
//
//    println(
//        deleteMiddle(
//            createListNode(values = intArrayOf(2,1))
//        )?.getValues()
//    )

    println(
        minSubArrayLen(7, intArrayOf(2,3,1,2,4,3))
    )

    println(
        minSubArrayLen(4, intArrayOf(1,4,4))
    )

    println(
        minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1))
    )

    println(
        minSubArrayLen(213, intArrayOf(12,28,83,4,25,26,25,2,25,25,25,12))
    )

}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    val prefixSum = IntArray(nums.size + 1)

    (nums.indices).forEach { index ->
        prefixSum[index + 1] = prefixSum[index] + nums[index]
    }

    var firstPointer = 0
    var secondPointer = 1

    var min = Int.MAX_VALUE
    while (secondPointer != nums.size){
        if (prefixSum[secondPointer] - prefixSum[firstPointer] >= target){
            min = min(min, secondPointer - firstPointer)
            if (firstPointer++ >= secondPointer) secondPointer++
        } else {
            secondPointer++
        }
    }

    while (firstPointer != nums.size){
        if (prefixSum[secondPointer] - prefixSum[firstPointer] >= target){
            min = min(min, secondPointer - firstPointer)
            firstPointer++
        } else { break }
    }

    return if (min == Int.MAX_VALUE) 0 else min
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







