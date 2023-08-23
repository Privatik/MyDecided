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
        leafSimilar(
            root1 = createTreeNode(0, listOf(3,5,1,6,2,9,8,null,null,7,4)),
            root2 = createTreeNode(0, listOf(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8))
        )
    )

    println(
        leafSimilar(
            root1 = createTreeNode(0, listOf(1,2,3)),
            root2 = createTreeNode(0, listOf(1,3,2)),
        )
    )

}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val ans1  = mutableListOf<Int>()
    findLeaf(root1, ans1)

    val ans2 = mutableListOf<Int>()
    findLeaf(root2, ans2)

    return ans1.size == ans2.size && (0 until ans1.size).all { index -> ans1[index] == ans2[index] }
}

private fun findLeaf(
    head: TreeNode?,
    answer: MutableList<Int>
){
    if (head == null) return

    if (
        head.left == null
        && head.right == null
    ){
        answer.add(head.`val`)
    }

    findLeaf(head.left, answer)
    findLeaf(head.right, answer)
}

fun pathSum(root: TreeNode?, sum: Int): Int {
    val preSum = HashMap<Int, Int>()
    preSum[0] = 1
    return helper(root, 0, sum, preSum)
}

fun helper(root: TreeNode?, beforeSum: Int, target: Int, preSum: HashMap<Int, Int>): Int {
    if (root == null) { return 0 }

    val currSum = beforeSum + root.`val`

    var res = preSum.getOrDefault(currSum - target, 0)
    preSum[currSum] = preSum.getOrDefault(currSum, 0) + 1

    res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum)
    preSum[currSum] = preSum[currSum]!! - 1

    return res
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





