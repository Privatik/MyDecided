import java.util.*


const val codeA = 1040

fun main() {
//
//    println(
//        oddEvenList(createListNode(array = intArrayOf(1,2,3,4,5)))?.getValues()
//    )

//    println(
//        missingNumber(intArrayOf(1))
//    )
//
//    println(
//        missingNumber(intArrayOf(3,0,1))
//    )
//
//    println(
//        missingNumber(intArrayOf(0,1))
//    )
//
//    println(
//        missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1))
//    )
//
//    println(
//        missingNumber(intArrayOf(0,3,5,8,4,6,1,9,7))
//    )

    println(
        minReorder(
            6,
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(1,3),
                intArrayOf(2,3),
                intArrayOf(4,0),
                intArrayOf(4,5),
            )
        )
    )

    println(
        minReorder(
            5,
            arrayOf(
                intArrayOf(1,0),
                intArrayOf(1,2),
                intArrayOf(3,2),
                intArrayOf(3,4),
            )
        )
    )

    println(
        minReorder(
            3,
            arrayOf(
                intArrayOf(1,0),
                intArrayOf(2,0),
            )
        )
    )

}

fun minReorder(n: Int, connections: Array<IntArray>): Int{
    return 0
}

private fun helper(
    isConnected: Array<IntArray>,
    currentCity: Int = 0,
    visitedCity: BooleanArray
) {
    println("enter to $currentCity")
    visitedCity[currentCity] = true
    (visitedCity.indices).forEach { city ->
        if (isConnected[currentCity][city] != 0 && !visitedCity[city]){
            helper(isConnected, city, visitedCity)
        }
    }
}

fun sumRootToLeaf(root: TreeNode?, current: Int = 0): Int {
    if(root == null) return 0
    val value = (current*2) + root.`val`
    if(root.left == null && root.right == null) return value
    return sumRootToLeaf(root.left, value) + sumRootToLeaf(root.right, value)
}

//fun sumRootToLeaf(root: TreeNode?): Int {
//    val space = IntArray(32)
//    return dfs(space, root, 0)
//}


fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int {
    return (arrivalTime + delayedTime) % 24
}


fun oddEvenList(head: ListNode?): ListNode? {
    var oddNodes = head
    var evenNodes = head?.next

    val headOddNodes = oddNodes
    val headEvenNodes = evenNodes

    while (evenNodes != null){
        oddNodes?.next = evenNodes.next
        if (oddNodes?.next != null) oddNodes = oddNodes.next

        evenNodes.next = oddNodes?.next
        evenNodes = evenNodes.next
    }

    oddNodes?.next = headEvenNodes
    return headOddNodes
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

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createListNode(index: Int = 0, array: IntArray): ListNode? {
    if (index !in array.indices) return null
    val node = ListNode(array[index])
    node.next = createListNode(index + 1, array)
    return node
}

//1,null,1,1,1,null,null,1,1,null,1,null,null,null,1
fun createTreeNode(index: Int = 0, list: List<Int?>): TreeNode? {
    if (index !in list.indices) return null
    if (list[index] == null) return null
    val node = TreeNode(list[index]!!)
    node.left = createTreeNode((index*2) + 1, list)
    node.right = createTreeNode((index*2) + 2, list)
    return node
}

fun TreeNode.getValues(): String{
    return getValues(this).joinToString(" ")
}

fun TreeNode.getValues(
    node: TreeNode,
) : List<Int?> {
    val answer = mutableListOf<Int?>()
    val queue: Queue<TreeNode> = LinkedList()
    answer.add(`val`)
    queue.offer(node)

    while (queue.isNotEmpty()){
        val currentNode = queue.poll()
        answer.add(currentNode.left?.`val`)
        answer.add(currentNode.right?.`val`)

        if (currentNode.left != null) queue.offer(currentNode.left)
        if (currentNode.right != null) queue.offer(currentNode.right)
    }

    return answer
}

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}





