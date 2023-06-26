import java.util.*

fun main() {


//    println(
//        longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0),2)
//    )

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
        val current = nums[index]
        if (current == 0 && countCanUse > 0){
            countCanUse--
            lastAvailableZeroIndex = index + 1
        }

        index++
        max++
    }

    println("exit from fist cycle index = ${index} max = ${max} lastAvailableZeroIndex = ${lastAvailableZeroIndex}")

    var nextMax = max
    while (index < nums.size){
        if (nextMax > max){
            max = nextMax
        }

        if (nums[index] == 1){
            nextMax++
            index++
            println("index = 1 , current index $index ${nextMax}")
            continue
        }
        if (nums[index] == 0){
            println("index = 0 , current index $index ${nextMax}")
            if (countCanUse > 0){
                nextMax++
                countCanUse--
                index++
                lastAvailableZeroIndex = index
                println("countCanUse was more 0 , current index $index ${nextMax}")
                continue
            }
            if (nums[index - max] == 1){
                nextMax = k + (index - lastAvailableZeroIndex)
                println("update , current index $index ${nextMax}")
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







