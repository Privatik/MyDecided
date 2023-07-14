import java.util.*
import kotlin.collections.ArrayList

const val codeA = 1040

fun main() {
//
//    val text = "ФРЗОРРТЯЫРЗГТЭЕХКФЯБЮФМЫОМОЯЬ"
//    val gamma = "РАЗДРАКОНДВАДРАКОНАТРИДРАКОНА"
//    val builder = StringBuilder()
//
//
//    text.indices.forEach { index ->
//        val dif = (text[index] - gamma[index]) % 32
//        builder.append(Char(codeA + dif))
//    }
//
//    val text1 = "ДРАКАРИС ОМЕГО НЕЛьЗЯ ПОМИЛОВАТЬ"
//
//    println(builder.toString())

    println(
        closeStrings("abc","bca")
    )

    println(
        closeStrings("a","aa")
    )

    println(
        closeStrings("cabbba","abbccc")
    )


}

fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val elWord1 = IntArray(26)
    word1.forEach { element ->
        elWord1[element - 'a']++
    }
    elWord1.sortDescending()

    val elWord2 = IntArray(26)
    word2.forEach { element ->
        elWord2[element - 'a']++
    }
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







