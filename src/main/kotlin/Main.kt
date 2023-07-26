
import java.util.*
import kotlin.math.log10


const val codeA = 1040

fun main() {

    println(
        decodeString("3[a]2[bc]")
    )

    println(
        decodeString("3[a2[c]]")
    )

    println(
        decodeString("2[abc]3[cd]ef")
    )

}

fun decodeString(s: String): String {
    val builder = StringBuilder()

    val stack = Stack<Char>()
    val digits = Stack<Int>()

    var digit = 0
    var index = 0
    while (index < s.length){
        if (s[index].isDigit()) { digit = digit*10 + (s[index] - '0') }
        else if (s[index] == '[') {
            digits.push(digit)
            digit = 0
            if (s[index] == ']')
        } else {
            stack.push(s[index])
        }
        index++
    }
}

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







