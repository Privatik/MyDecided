fun main(args: Array<String>) {
    println(
        findPeakElement(intArrayOf(1,0,1,3,3,5,6,4))
    )

    println(
        findPeakElement(intArrayOf(1,2,3,1))
    )

}

fun findPeakElement(nums: IntArray): Int {
    if (nums.size == 1) return 0

    val n: Int = nums.size

    if (nums[0] > nums[1]) return 0
    if (nums[n - 1] > nums[n - 2]) return n - 1

    var start = 1
    var end = n - 2

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid else if (nums[mid] < nums[mid - 1]) end =
            mid - 1 else if (nums[mid] < nums[mid + 1]) start = mid + 1
    }
    return -1
}







