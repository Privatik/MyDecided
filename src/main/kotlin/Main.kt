import java.util.*

fun main(args: Array<String>) {
    println(
        deleteDuplicates(
            head = ListNode(1).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(2,3,3,4,4,5)) }
                add(list)
            }
        )
    )

    println(
        deleteDuplicates(
            head = ListNode(1).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(1,1,2,3)) }
                add(list)
            }
        )
    )

}

fun deleteDuplicates(head: ListNode?): ListNode?{
    if (head?.next == null) return head

    var root: ListNode? = null
    var nextRoot: ListNode? = null

    var firstPoint = head
    var secondPoint = head.next

    val moreTwoTimesSet = hashSetOf<Int>()

    while (secondPoint != null){
        if (firstPoint.`val` == secondPoint.`val`) {
            moreTwoTimesSet.add(secondPoint.`val`)
            secondPoint = secondPoint.next


        }

    }

    return root
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







