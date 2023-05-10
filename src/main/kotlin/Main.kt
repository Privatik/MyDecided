import java.util.*

fun main(args: Array<String>) {
    println(
        increasingTriplet(intArrayOf(1,2,3,4,5))
    )

    println(
        increasingTriplet(intArrayOf(5,4,3,2,1))
    )

    println(
        increasingTriplet(intArrayOf(2,1,5,0,4,6))
    )

}

fun increasingTriplet(nums: IntArray): Boolean {
    if (nums.size < 3) return false

    var index = 0
    var secondValue = Int.MIN_VALUE
    var tripleValue = Int.MIN_VALUE

    while (true){
        val value = nums[index + 1]

        if (value > secondValue){
            secondValue = value
            index++
            continue
        }

        if ()

        return true
    }

    return false
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







