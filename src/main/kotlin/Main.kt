import java.util.*

fun main(args: Array<String>) {

    println(
        maxVowels("abciiidef",3)
    )

    println(
        maxVowels("aeiou",2)
    )

    println(
        maxVowels("leetcode",3)
    )

}

private val vowel = intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)


fun maxVowels(s: String, k: Int): Int {
    var r0 = 0
    for (i in 0 until k)
        r0 += vowel[s[i] - 'a']
    var r = r0
    for (i in k until s.length) {
        r0 -= vowel[s[i - k] - 'a']
        r0 += vowel[s[i] - 'a']
        if (r0 > r)
            r = r0
    }
    return r
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







