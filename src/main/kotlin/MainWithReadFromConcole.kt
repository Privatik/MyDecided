import java.lang.Integer.max

const val WATER = '~'
const val EMPTY = '.'
const val STONE = '*'

fun main(){
    val count = readLine()!!.toInt()
    val result = StringBuilder()
    repeat(count){ rootIndex ->
        if (rootIndex != 0){
            result.append("\n")
        }
        val values = readLine()!!.split(" ").map { it.toInt() }

        val n = values[0]
        val k = values[1]
        val pool = Array(k) { 0 }
        val water = Array(k) { 0 }
        repeat(n){
            readLine()!!.forEachIndexed { index, element ->
                if (element == STONE){
                    pool[index]++
                }
            }
        }

        val max = pool.maxOrNull()
        val firstMax = pool.indexOfFirst { max == it }
        val lastMax = pool.indexOfLast { max == it }

        var maxIndex = 0
        for (index in 1 until firstMax){
            if (pool[maxIndex] <= pool[index]) {
                maxIndex = index
            } else {
                water[index] = pool[maxIndex] - pool[index]
            }
        }

        for (index in firstMax + 1 until lastMax){
            water[index] = pool[firstMax] - pool[index]
        }

        maxIndex = pool.size - 1
        for (index in pool.size - 2 downTo lastMax + 1){
            if (pool[maxIndex] <= pool[index]) {
                maxIndex = index
            } else {
                water[index] = pool[maxIndex] - pool[index]
            }
        }

        for (row in n downTo 1){
            for (column in 0 until k){
                val w = water[column]
                val p = pool[column]
                if (w + p >= row){
                    if (w != 0){
                        result.append(WATER)
                        water[column]--
                    } else {
                        result.append(STONE)
                    }
                } else{
                    result.append(EMPTY)
                }
            }

            result.append("\n")
        }
    }

    println(result)
}