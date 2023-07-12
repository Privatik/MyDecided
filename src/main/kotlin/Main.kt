import java.util.*
import kotlin.collections.ArrayList

fun main() {

    println(
        findDifference(
            intArrayOf(1,2,3),
            intArrayOf(2,4,6),
        )
    )

    println(
        findDifference(
            intArrayOf(1,2,3,3),
            intArrayOf(1,1,2,2),
        )
    )

    println(
        findDifference(
            intArrayOf(-3,6,-5,4,5,5),
            intArrayOf(6,6,-3,-3,3,5),
        )
    )

}


fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val list = ArrayList<List<Int>>(2)

    val firstSet = hashSetOf<Int>()
    val secondSet = nums2.toHashSet()
    val removedSet = hashSetOf<Int>()

    nums1.forEach { item ->
        if (!secondSet.contains(item) && !removedSet.contains(item)) firstSet.add(item)
        secondSet.remove(item)
        removedSet.add(item)
    }

    list.add(firstSet.toList())
    list.add(secondSet.toList())

    return list
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







