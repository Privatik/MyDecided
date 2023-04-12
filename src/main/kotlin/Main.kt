import java.util.*

fun main(args: Array<String>) {
    println(
        deleteDuplicates(
            head = ListNode(1).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(2,3,3,4,4,5)) }
                add(list)
            }
        )?.getValues().toString()
    )

    println(
        deleteDuplicates(
            head = ListNode(1).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(1,1,1)) }
                add(list)
            }
        )?.getValues().toString()
    )

    println(
        deleteDuplicates(
            head = null
        )?.getValues().toString()
    )

    println(
        deleteDuplicates(
            head = ListNode(2)
        )?.getValues().toString()
    )

    println(
        deleteDuplicates(
            head = ListNode(2).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(3,4,5,5)) }
                add(list)
            }
        )?.getValues().toString()
    )

    println(
        deleteDuplicates(
            head = ListNode(1).apply {
                val list = LinkedList<Int>().apply { addAll(listOf(1,1,2,3)) }
                add(list)
            }
        )?.getValues().toString()
    )

}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var node: ListNode? = ListNode(101)
    node?.next = head
    val result = node
    while (node?.next != null) {
        val curr = node.next!!.`val`
        var tmp = node.next!!.next
        var hasDuplicate = false
        while (tmp != null && curr == tmp.`val`) {
            tmp = tmp.next
            hasDuplicate = true
        }
        if (hasDuplicate) node.next = tmp
        else node = node.next
    }
    return result?.next
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







