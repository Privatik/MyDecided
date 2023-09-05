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
        findCircleNum(
            arrayOf(
                intArrayOf(1,1,0),
                intArrayOf(1,1,0),
                intArrayOf(0,0,1),
            )
        )
    )

    println(
        findCircleNum(
            arrayOf(
                intArrayOf(1,0,0),
                intArrayOf(0,1,0),
                intArrayOf(0,0,1),
            )
        )
    )

}

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var result = 0
    val visitedCity = BooleanArray(isConnected.size)
    (isConnected.indices).forEach { city ->
        result += helper(isConnected, city, visitedCity)
    }
    return result
}

private fun helper(
    isConnected: Array<IntArray>,
    currentCity: Int = 0,
    visitedCity: BooleanArray
) : Int{
    var countProvinces = 1
    visitedCity[currentCity] = true
    (currentCity + 1 until visitedCity.size).forEach { city ->
        if (isConnected[currentCity][city] != 0 && !visitedCity[city]){
            countProvinces++
            helper(isConnected, city, visitedCity)
        }
    }
    return countProvinces
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





