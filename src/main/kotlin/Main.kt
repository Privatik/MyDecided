import java.util.*


const val codeA = 1040

fun main() {

    println(
        removeStars("leet**cod*e")
    )

    println(
        removeStars("erase*****")
    )

}

fun removeStars(s: String): String {
    val builder = StringBuilder()

    s.indices.forEach { index ->
        val item = s[index]
        if (item == '*'){
            if (builder.isNotEmpty()) builder.deleteCharAt(builder.length - 1)
        } else {
            builder.append(item)
        }
    }

    return builder.toString()
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







