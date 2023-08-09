import kotlin.math.pow

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
        sumRootToLeaf(
            TreeNode(1).apply {
                left = TreeNode(0).apply {
                    left = TreeNode(0)
                    right = TreeNode(1)
                }
                right = TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(1)
                }
            }
        )
    )

    println(
        sumRootToLeaf(TreeNode(0))
    )

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

fun dfs(
    space: IntArray,
    node: TreeNode?,
    currentIndex: Int,
): Int {
    var sum = 0
    if (node == null) return sum

    space[currentIndex] = node.`val`
    if (node.left == null && node.right == null){
        (0..currentIndex).forEach { index ->
            sum += 2.0.pow(index.toDouble()).toInt() * space[currentIndex - index]
        }
    } else {
        sum += dfs(space, node.left, currentIndex + 1)
        sum += dfs(space, node.right, currentIndex + 1)
    }

    return sum
}

fun missingNumber(nums: IntArray): Int {
    nums.sort()

    var left = 0
    var right = nums.size - 1
    while (left <= right){
        if (right - left < 3){
            (left..right).forEach { index ->
                if (index != nums[index]) return index
            }
            break
        }

        val mid = ((left + right) / 2) + 1
        val item = nums.binarySearch(mid, left, right)
        if (item < 0) return mid

        if (item < mid){
            right = mid
        } else {
            left = mid + 1
        }
    }


    return nums.size
}

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

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}





