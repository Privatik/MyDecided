import java.util.*
import kotlin.collections.ArrayList

const val codeA = 1040

fun main() {

    println(
        equalPairs(
            arrayOf(
                intArrayOf(3,2,1),
                intArrayOf(1,7,6),
                intArrayOf(2,7,7),
            )
        )
    )

    println(
        equalPairs(
            arrayOf(
                intArrayOf(3,1,2,2),
                intArrayOf(3,1,2,2),
                intArrayOf(2,4,2,2),
                intArrayOf(2,4,2,2),
            )
        )
    )

}

fun equalPairs(grid: Array<IntArray>): Int {
    val cache = Array(grid.size) { BooleanArray(grid.size) }
    cache[0][0] = true

    grid.indices.forEach { row ->
        var column  = 0
        while (column < grid.size){
            if (row > column) {
                column++
                continue
            }
            if (column == row) {
                cache[row][column] = true
                cache[column][row] = true
            }
            if (
                cache[row].getOrElse(column - 1) { true } &&
                cache.getOrNull(row - 1)?.get(column) == true &&
                grid[row][column] == grid[column][row]
            ){
                cache[row][column] = true
                cache[column][row] = true
            }
            column++
        }
    }


    cache.indices.forEach { row ->
        cache.indices.forEach { column ->
            print(" ${cache[row][column]}")
        }
        println()
    }

    return 0
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







