import java.util.*

fun main(args: Array<String>) {

    println(
        longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0),2)
    )

    println(
        longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1),3)
    )

}


fun longestOnes(nums: IntArray, k: Int): Int {
    var max = 0
    var countCanUse = k
    var index = 0
    var lastAvailableZeroIndex = 0

    while (countCanUse > 0 && index < nums.size){
        if (nums[index] == 0 && countCanUse > 0){
            countCanUse--
            lastAvailableZeroIndex = index
        }

        index++
        max++
    }

    var nextMax = max
    while (index < nums.size){
        if (nextMax > max){
            max = nextMax
        }

        if (nums[index] == 1){
            nextMax++
            index++
            continue
        }
        if (nums[index] == 0){
            if (countCanUse > 0){
                nextMax++
                countCanUse--
                index++
                continue
            }
            if (nums[index - max] == 1){
                nextMax = k + (index - lastAvailableZeroIndex)
            }
            index++
        }
    }

    if (nextMax > max){
        max = nextMax
    }

    return max
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







