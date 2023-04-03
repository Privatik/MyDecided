fun main(args: Array<String>) {
//    println(
//        search(
//            intArrayOf(8,1,2,3,4,5,6,7),
//            6
//        )
//    )

    println(
        search(
            intArrayOf(4,5,6,7,0,1,2),
            0
        )
    )

    println(
        search(
            intArrayOf(4,5,6,7,0,1,2),
            3
        )
    )

    println(
        search(
            intArrayOf(4,5,6,7,8,1,2,3),
            8
        )
    )

    println(
        search(
            intArrayOf(3,1),
            1
        )
    )

    println(
        search(
            intArrayOf(5,1,3),
            1
        )
    )

    println(
        search(
            intArrayOf(3,1),
            0
        )
    )

    println(
        search(
            intArrayOf(1,3),
            0
        )
    )

    println(
        search(
            intArrayOf(1),
            0
        )
    )

}

fun search(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.lastIndex
    while (low <= high) {
        val mid = (low + high) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[mid] >= nums[low]) {
            if (target in nums[low]..nums[mid]) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        } else {
            if (target in nums[mid]..nums[high]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
    }
    return -1
}