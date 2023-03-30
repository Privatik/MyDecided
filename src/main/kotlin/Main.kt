fun main(args: Array<String>) {
    println(
        searchRange(
            intArrayOf(5,7,8,8,8,10),
            8
        ).joinToString(" ")
    )

    println(
        searchRange(
            intArrayOf(5,7,8,8,9,10),
            8
        ).joinToString(" ")
    )

    println(
        searchRange(
            intArrayOf(5,8,8,9,9,10),
            8
        ).joinToString(" ")
    )

    println(
        searchRange(
            intArrayOf(1,3),
            1
        ).joinToString(" ")
    )

    println(
        searchRange(
            intArrayOf(5,7,7,8,8,10),
            8
        ).joinToString(" ")
    )

    println(
        searchRange(
            intArrayOf(5,7,7,8,8,10),
            6
        ).joinToString(" ")
    )


    println(
        searchRange(
            intArrayOf(),
            0
        ).joinToString(" ")
    )
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    fun search(lowerBound: Boolean): Int {
        var lower = 0
        var upper = nums.size - 1
        while (lower != upper) {
            val mid = lower/2 + upper/2
            val element = nums[mid]
            when {
                element < target -> lower = mid+1
                element > target -> upper = mid
                lowerBound -> upper = mid
                else -> if (nums[mid+1] == target) lower = mid+1 else return mid
            }
        }

        return if (nums[lower] == target) lower else -1
    }

    return if (nums.isEmpty()) intArrayOf(-1, -1) else intArrayOf(search(true), search(false))
}