import java.util.*

fun main(args: Array<String>) {

    var arr = intArrayOf(0,1,0,3,12)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

    arr = intArrayOf(0)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

    arr = intArrayOf(0,1,2,3,4,5)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

    arr = intArrayOf(1,2,3,4,5, 0, 0)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

    arr = intArrayOf(1,0,0,0,5, 0, 0)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

    arr = intArrayOf(1,0,2,0,5, 0, 2)
    println(
        moveZeroes(arr)
    )
    println(arr.joinToString(" "))

}

fun moveZeroes(nums: IntArray): Unit {
    var zeroPointer = -1
    var nonZeroPonter = 0

    while (nonZeroPonter < nums.size && nums[nonZeroPonter] != 0) { nonZeroPonter++ }

    zeroPointer = nonZeroPonter
    nonZeroPonter++

    while (nonZeroPonter < nums.size){
        if (nums[nonZeroPonter] != 0){
            nums[zeroPointer] = nums[nonZeroPonter]
            nums[nonZeroPonter] = 0
            zeroPointer++
        }
        nonZeroPonter++
    }
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







