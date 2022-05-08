fun main(){
    readLine()
    val number = readLine()!!.split(" ").map { it.toInt() }

    var result = Array(number.size + 1){ 0 }

    var counter = -1

    while (counter != result.lastIndex){
        result = Array(number.size + 1){ 0 }
        var isNegative = false
        counter += 1
        for (index in counter - 1 downTo 0){
            val element = result[index + 1] - number[index]
            if (element < 0) {
                isNegative = true
                break
            }
            result[index] = element
        }

        if (isNegative){
            continue
        }

        for (index in counter + 1 until result.size){
            val element = number[index - 1] + result[index - 1]
            if (element < 0) {
                isNegative = true
                break
            }
            result[index] = element
        }

        if (!isNegative){
            break
        }
    }

    println(result.joinToString(" "))
}