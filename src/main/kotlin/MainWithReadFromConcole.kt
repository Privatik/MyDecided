/*
5 5
**.**
*...*
.....
*...*
**.**
 */

const val BOAT ='*'
const val POINT ='.'

const val NO = "NO"
const val YES = "YES"

fun main(){
    val result = StringBuilder()
    var isExit = false
    readLine()!!.split(" ").also { nAndm ->
        val n = nAndm[0].toInt()
        val m = nAndm[1].toInt()

        val arr = Array(n) { Array(m) {0} }
        val list = mutableListOf<Int>()

        for (i in 0 until n){
            val row = readLine()!!
            for (j in 0 until m){
                arr[i][j] = row[j].getCorrect()

                if (i != 0 && j != 0){
                    if (arr[i - 1][j - 1] != 0){
                        isExit = true
                    }
                }

                if (j != 0){
                    val value = arr[i][j - 1]
                    if (value != 0){
                        val r = value + 1
                        arr[i][j] = r
                        for(indexJ in j-(r-1) until j){
                            arr[i][indexJ] = r
                        }
                    }
                }

                if (i != 0){
                    val value = arr[i - 1][j]
                    if (value != 0){
                        val r = value - 1
                        arr[i][j] = r
                        for(indexI in i-(r-1) until i){
                            arr[indexI][j] = r
                        }
                    }
                }
            }
        }
    }

    if (isExit) {
        result.append(NO)
    }

    println(result)
}

fun Char.getCorrect(): Int{
    return when (this){
        BOAT -> 1
        POINT -> 0
        else -> error("")
    }
}