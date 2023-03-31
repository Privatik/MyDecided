fun main(args: Array<String>) {
    println(
        search(
            intArrayOf(8,1,2,3,4,5,6,7),
            6
        )
    )

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
    val isFoundInRight = nums.last() < nums.first() && nums.last() > target

    var lower = 0
    var upper = nums.lastIndex

    while (lower < upper){
        when (target) {
            nums[lower] -> { return lower }
            nums[upper] -> { return upper }
        }

        val mid = lower/2 + upper/2

        when {
            nums[mid] == target -> { return mid }
            nums[mid] > target -> {
                if (isFoundInRight){
                    lower = mid + 1
                } else {
                    upper = mid - 1
                }
            }
            nums[mid] < target -> {
                if (isFoundInRight) {
                    upper = mid - 1
                } else {
                    lower = mid + 1
                }
            }
        }
    }


    return if (nums[lower] == target) lower else -1
}