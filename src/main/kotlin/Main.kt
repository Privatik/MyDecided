import java.util.*

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

//    println(
//        letterCombinations("23").joinToString(" ")
//    )
//
//    println(
//        letterCombinations("").joinToString(" ")
//    )
//
//    println(
//        letterCombinations("7").joinToString(" ")
//    )
//
//    println(
//        letterCombinations("8").joinToString(" ")
//    )
//
//    println(
//        letterCombinations("9").joinToString(" ")
//    )
//
//    println(
//        letterCombinations("67").joinToString(" ")
//    )


    println(
        trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
    )

    println(
        trap(intArrayOf(4,2,0,3,2,5))
    )

}

fun trap(height: IntArray): Int {
    val result = IntArray(height.size)

    var lastMax = height[0]
    (1 until height.size).forEach { index ->
        if (lastMax > height[index]){
            result[index] = lastMax - height[index]
        } else {
            lastMax = height[index]
        }
    }

    val stopHeight = lastMax
    lastMax = height[height.size - 1]
    var index = height.size - 2
    while (lastMax != stopHeight){
        if (lastMax > height[index]){
            result[index] = lastMax - height[index]
        } else {
            lastMax = height[index]
        }
        index--
    }

    return result.sum()
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return listOf()

    val result = LinkedList<String>()
    backTracking(0, digits, StringBuilder(), result)
    return result
}

fun backTracking(
    index: Int,
    digits: String,
    builder: StringBuilder,
    result: LinkedList<String>
) {
    if (index >= digits.length) {
        result.add(builder.toString())
        return
    }

    val number = digits[index] - '2'
    val startChar = if (number <= 5 ){ 'a' + (3 * number) } else { 'a' + (3 * (number - 1)) + 4 }

    (startChar until startChar + (if (number == 5 || number == 7) 4 else 3)).forEach { item ->
        builder.append(item)
        backTracking(index + 1, digits, builder, result)
        builder.deleteCharAt(index)
    }
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val cache = IntArray(nums.size) { -1 }

    return intArrayOf()
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







