import java.util.*

fun main(args: Array<String>) {
    println(
        backspaceCompare("ab#c","ad#c")
    )

    println(
        backspaceCompare("ab##","c#d#")
    )

    println(
        backspaceCompare("a#c","b")
    )

}

fun backspaceCompare(s: String, t: String): Boolean {
    val back = '#'

    var indexFirstWord = s.lastIndex
    var indexSecondWord = t.lastIndex

    var countBackInFirst = 0
    var countBackInSecond = 0

    var answer = true

    while (answer){
        var indexNotBackInFirst = false
        var indexNotBackInSecond = false

        if (indexFirstWord > 0 && s[indexFirstWord] == back){
            countBackInFirst++
            indexFirstWord--
        } else {
            if (countBackInFirst != 0){
                countBackInFirst--
                indexFirstWord--
            } else {
                indexNotBackInFirst = true
            }
        }

        if (indexSecondWord > 0 && t[indexSecondWord] == back){
            countBackInSecond++
            indexSecondWord--
        } else {
            if (countBackInSecond != 0){
                countBackInSecond--
                indexSecondWord--
            } else {
                indexNotBackInSecond = true
            }
        }

        if (indexNotBackInFirst && indexNotBackInSecond){
            if (s.getOrNull(indexFirstWord) != t.getOrNull(indexSecondWord)) {
                answer = false
            } else {
                if (indexFirstWord < 0 && indexSecondWord < 0) { break }
                indexFirstWord--
                indexSecondWord--
            }
        }
    }

    return answer
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







