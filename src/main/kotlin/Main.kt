import java.util.*
import kotlin.collections.ArrayList

fun main() {

    println(
        uniqueOccurrences(
            intArrayOf(1,2,2,1,1,3)
        )
    )

    println(
        uniqueOccurrences(
            intArrayOf(1,2)
        )
    )

    println(
        uniqueOccurrences(
            intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)
        )
    )

}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val count = IntArray(arr.size)
    val map = hashMapOf<Int, Int>()
    arr.forEach { value ->
        val newValue = (map[value] ?: 0) + 1
        map[value] = newValue
        count[newValue]++
        if (newValue != 1) count[newValue - 1]--
    }

    return count.none { it > 1 }
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







