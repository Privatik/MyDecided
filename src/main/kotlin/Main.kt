import java.util.*

fun main(args: Array<String>) {
    println(
        canPlaceFlowers(
            intArrayOf(1,0,0,0,1),
            1
        )
    )

    println(
        canPlaceFlowers(
            intArrayOf(1,0,0,0,1),
            2
        )
    )

}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var count = n

    flowerbed.indices.forEach { index ->
        if (flowerbed[index] != 1){
            var isCan = index == 0 || flowerbed[index - 1] == 0
            isCan = isCan && (index == flowerbed.size - 1 || flowerbed[index + 1] == 0)

            if (isCan && count != 0) {
                count--
                flowerbed[index] = 1
            }
        }
    }

    return count == 0
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







