import kotlin.math.min

fun main(args: Array<String>) {

    println(
        findMin(
            intArrayOf(3,4,5,1,2)
        )
    )

    println(
        findMin(intArrayOf(4,5,6,7,0,1,2))
    )

    println(
        findMin(intArrayOf(11,13,15,17))
    )

    println(
        findMin(intArrayOf(5,1,2,3,4))
    )

    println(
        findMin(intArrayOf(2,1))
    )

    println(
        findMin(intArrayOf(3,1,2))
    )

    println(
        findMin(intArrayOf(1,2,3))
    )

    println(
        findMin(intArrayOf(2,3,1))
    )

}

fun findMin(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1

    if (nums.size == 1) return nums[0]

    if (nums[end] > nums[0]) return nums[0]

    while (start < end) {
        var mid = start + (end - start) / 2

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1]
        }

        if (nums[mid - 1] > nums[mid]) {
            return nums[mid]
        }

        if (nums[mid] > nums[start]) {
            start = mid + 1
        } else {
            end = mid -1
        }
    }

    return -1
}







