import kotlin.math.abs

const val CROSS = 'X'
const val ZERO = '0'
const val EMPTY = '.'

const val YES = "YES"
const val NO = "NO"

fun main(){
    val verticalZero = Array(3) {0}
    val horizontalZero = Array(3) {0}

    val verticalCross = Array(3) {0}
    val horizontalCross = Array(3) {0}

    var countCross = 0
    var countZero = 0

    var isWin = false

    repeat(3){ row ->
        readLine()!!.forEachIndexed { column, c ->
            when (c){
                CROSS -> {
                    countCross++
                    verticalCross[row] += 1
                    horizontalCross[column] += 1
                    if (verticalCross[row] == 3 || horizontalCross[column] == 3){
                        if (isWin){
                            println(NO)
                            return
                        }
                        isWin = true
                    }
                }
                ZERO -> {
                    countZero++
                    verticalZero[row] += 1
                    horizontalZero[column] += 1
                    if (verticalZero[row] == 3 || horizontalZero[column] == 3){
                        if (isWin){
                            println(NO)
                            return
                        }
                        isWin = true
                    }
                }
                EMPTY -> { }
            }
        }
    }

    if (abs(countCross - countZero) > 1){
        println(NO)
        return
    }

    println(YES)
}