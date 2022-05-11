import kotlin.math.abs

const val CROSS = 'X'
const val ZERO = '0'
const val EMPTY = '.'

const val YES = "YES"
const val NO = "NO"

fun main(){
    val count = readLine()!!.toInt()
    val result = StringBuilder()
    repeat(count) { rootIndex ->
        readLine()
        val verticalZero = Array(3) {0}
        val horizontalZero = Array(3) {0}
        var positiveDiagonalZero = 0
        var negativeDiagonalZero = 0

        val verticalCross = Array(3) {0}
        val horizontalCross = Array(3) {0}
        var positiveDiagonalCross = 0
        var negativeDiagonalCross = 0

        var countCross = 0
        var countZero = 0

        var isWinCross = false
        var isWinZero = false

        repeat(3){ row ->
            readLine()!!.forEachIndexed { column, c ->
                when (c){
                    CROSS -> {
                        countCross++
                        verticalCross[row] += 1
                        horizontalCross[column] += 1
                        if (column == row) positiveDiagonalCross++
                        if (row == 2 - column) negativeDiagonalCross++
                        if (
                            verticalCross[row] == 3 ||
                            horizontalCross[column] == 3 ||
                            positiveDiagonalCross == 3 ||
                            negativeDiagonalCross == 3
                        ){
                            isWinCross = true
                        }
                    }
                    ZERO -> {
                        countZero++
                        verticalZero[row] += 1
                        horizontalZero[column] += 1
                        if (column == row) positiveDiagonalZero++
                        if (row == 2 - column) negativeDiagonalZero++
                        if (verticalZero[row] == 3 ||
                            horizontalZero[column] == 3 ||
                            positiveDiagonalZero == 3 ||
                            negativeDiagonalZero == 3
                        ){
                            isWinZero = true
                        }
                    }
                    EMPTY -> { }
                }
            }
        }

        if (isWinCross && isWinZero){
            result.append(NO)
            result.append("\n")
            return@repeat
        }

        if (isWinCross){
            if (countCross - countZero != 1){
                result.append(NO)
                result.append("\n")
                return@repeat
            }
        }

        if (isWinZero){
            if (countCross - countZero != 0){
                result.append(NO)
                result.append("\n")
                return@repeat
            }
        }

        if (countCross - countZero !in 0..1){
            result.append(NO)
            result.append("\n")
            return@repeat
        }

        result.append(YES)
        if (rootIndex != count - 1){
            result.append("\n")
        }

    }

    println(result)
}