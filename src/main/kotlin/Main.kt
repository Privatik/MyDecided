
import java.util.*
import kotlin.math.log10


const val codeA = 1040

fun main() {

    println(
        asteroidCollision(intArrayOf(5,10,-5)).joinToString(" ")
    )

    println(
        asteroidCollision(intArrayOf(8,-8)).joinToString(" ")
    )

    println(
        asteroidCollision(intArrayOf(10,2,-5)).joinToString(" ")
    )

}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    var index = 1

    stack.push(asteroids[0])
    while (index < asteroids.size && !stack.isEmpty()){
        val valueBefore = stack.peek()
        val dif = valueBefore + asteroids[index]

        if (dif == 0){
            stack.pop()
            val nextValue = asteroids.getOrNull(index + 1)
            if (nextValue != 0){ stack.push(nextValue) }
            index += 2
            continue
        }

        if (valueBefore > 0){
            if (dif < 0) {
                stack.pop();
                stack.push(asteroids[index])
            }
            else if (dif > valueBefore){
                stack.push(asteroids[index])
            }
        } else if (valueBefore < 0){
            if (dif > 0) {
                stack.pop();
                stack.push(asteroids[index])
            }
            else if (dif < valueBefore){
                stack.push(asteroids[index])
            }
        }
        index++
    }

    if (stack.size == 1){
        if (stack.peek() == null){
            return intArrayOf()
        }
    }

    val result = IntArray(stack.size)

    result.indices.reversed().forEach { insideIndex ->
        result[insideIndex] = stack.pop()
    }

    return result
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







