import java.util.*
import kotlin.collections.ArrayList

const val codeA = 1040

fun main() {

    println(
        closeStrings("abc","bca")
    )

    println(
        closeStrings("a","aa")
    )

    println(
        closeStrings("cabbba","abbccc")
    )

    println(
        closeStrings("uau","ssx")
    )

}

fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val elWord1 = IntArray(26)
    word1.forEach { element ->
        elWord1[element - 'a']++
    }

    val elWord2 = IntArray(26)
    word2.forEach { element ->
        elWord2[element - 'a']++
    }

    elWord1.indices.forEach { index ->
        if (elWord1[index] > 0 && elWord2[index] == 0) return false
        if (elWord2[index] > 0 && elWord1[index] == 0) return false
    }


    elWord1.sortDescending()
    elWord2.sortDescending()

    var index = 0
    while (index != elWord1.size){
        if (elWord1[index] == 0 && elWord2[index] == 0) break
        if (elWord1[index] != elWord2[index]) return false
        index++
    }

    return true
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







