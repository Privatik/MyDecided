
import java.util.*
import kotlin.math.log10


const val codeA = 1040

fun main() {
//
//    println(
//        decodeString("3[a]2[bc]")
//    )
//
//    println(
//        decodeString("3[a2[c]]")
//    )
//
//    println(
//        decodeString("2[abc]3[cd]ef")
//    )

    val array1 = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
    )

    println(
        rotate(array1)
    )

    println("---------")
    println(array1.joinToString("\n") { it.joinToString(" ") })
    println("---------")

    val array2 = arrayOf(
        intArrayOf(5,1,9,11),
        intArrayOf(2,4,8,10),
        intArrayOf(13,3,6,7),
        intArrayOf(15,14,12,16),
    )

    println(
        rotate(array2)
    )

    println("---------")
    println(array2.joinToString("\n") { it.joinToString(" ") })
    println("---------")

}

fun rotate(matrix: Array<IntArray>): Unit {
    if (matrix.size == 1) return

    val lastIndex = matrix.lastIndex
    (0 until (matrix.size + 1) / 2).forEach { firstPointer ->
        (0 until matrix.size / 2).forEach { secondPointer ->
            val s = matrix[firstPointer][secondPointer]
            matrix[firstPointer][secondPointer] =
                matrix[lastIndex - secondPointer][firstPointer]

            matrix[lastIndex - secondPointer][firstPointer] =
                matrix[lastIndex - firstPointer][lastIndex - secondPointer]

            matrix[lastIndex - firstPointer][lastIndex - secondPointer] =
                matrix[secondPointer][lastIndex - firstPointer]

            matrix[secondPointer][lastIndex - firstPointer] = s
        }
    }
}

//fun decodeString(s: String): String {
//    val builder = StringBuilder()
//
//    val stack = Stack<Char>()
//    val digits = Stack<Int>()
//
//    var digit = 0
//    var index = 0
//    while (index < s.length){
//        if (s[index].isDigit()) { digit = digit*10 + (s[index] - '0') }
//        else if (s[index] == '[') {
//            digits.push(digit)
//            digit = 0
//            if (s[index] == ']')
//        } else {
//            stack.push(s[index])
//        }
//        index++
//    }
//}

private fun decodeString(
    builder: StringBuilder,
    s: String,
    index: Int,
) : Int {
    var digit = 0
    var cIndex = index
    while (cIndex < s.length){
        if (s[cIndex].isDigit()) { digit = digit*10 + (s[cIndex] - '0') }
        else if (s[cIndex] == '[') {
            var insideIndex = cIndex + 1
            while (digit != 0){
                if (s[insideIndex] == '['){
                    insideIndex = decodeString(builder, s, insideIndex)
                } else {
                    builder.append(s[insideIndex])
                    insideIndex++
                }
                if (s[insideIndex] == ']'){
                    if (--digit != 0) insideIndex = cIndex + 1
                }
            }
            cIndex = insideIndex
        } else {
            builder.append(s[cIndex])
        }
        cIndex++
    }
    return cIndex
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







