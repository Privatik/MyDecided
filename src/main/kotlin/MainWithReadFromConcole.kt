/*
3 5
1 10
2 9
3 8
4 7
5 6
 */

data class Session(
    val n: Int,
    val workPairs: List<Pair<Int, Int>>
)

fun main(){
    val count = readLine()!!.toInt()
    val sessions = Array<Session?>(count) { null }
    val result = StringBuilder()
    repeat(count){ rootIndex ->
        readLine()
        readLine()!!.split(" ").also {
            val n = it[0].toInt()
            val k = it[1].toInt()

            val list = List(k) {
                val longValue = readLine()!!.split(" ").map { s -> s.toInt() }
                Pair(longValue[0], longValue[1])
            }
            sessions[rootIndex] = Session(n, list)
        }
    }

    sessions.forEachIndexed { index, session ->
        val workArr = Array<Int>(session!!.n) { 0 }
        val resultCurrentWork = StringBuilder()

        session.workPairs.forEach { pair ->
            var isAdd = false

            var wIndex = 0

            var minThread = 0

            while (wIndex < workArr.size){
                val currentValue = workArr[wIndex]
                if (pair.first >= currentValue){
                    val value = pair.first + pair.second
                    resultCurrentWork.append(value)
                    workArr[wIndex] = value

                    isAdd = true
                    break
                }

                if (workArr[minThread] > currentValue){
                    minThread = wIndex
                }

                wIndex++
            }

            if (!isAdd){
                val update = workArr[minThread] + pair.second
                resultCurrentWork.append(update)
                workArr[minThread] = update
            }

            if (index != session.workPairs.size - 1){
                resultCurrentWork.append(" ")
            }
        }

        result.append(resultCurrentWork)
        if (index != count - 1){
            result.append("\n")
        }
    }

    println(result)
}