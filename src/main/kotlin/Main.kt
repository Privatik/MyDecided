fun main() {


    println(pivotIndex(intArrayOf(1,7,3,6,5,6)))

    println(pivotIndex(intArrayOf(1,2,3)))

    println(pivotIndex(intArrayOf(2,1,-1)))

}


fun pivotIndex(nums: IntArray): Int {
    var rightSum = nums.sum() - nums[0]
    var leftSum = 0

    if (leftSum == rightSum) return 0

    repeat(nums.size - 1){ i ->
        val index = i + 1
        leftSum += nums[index - 1]
        rightSum -= nums[index]

        if (leftSum == rightSum) return index
    }

    return -1
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







