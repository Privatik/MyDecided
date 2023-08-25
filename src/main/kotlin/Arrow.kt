import kotlin.math.*

class Arrow {

    init {
        println("init no static block")
    }

    constructor(count: Int){
        println("constructor block")
    }

    constructor(count: Int, number: Int){
        println("constructor block 1")
    }

    private val offset = 3.0
    private val offsetCather  = 2.0
    fun draw(){
        val startPoint = Point(0.0, 0.0)
        val endPoint = Point(0.0, 3.0)
        val des = atan2((endPoint.y - startPoint.y),(endPoint.x - startPoint.x))

        val w = 2.356194490192345// 135
        val w2 = 1.5707963267948966 // 90

        val firstPoint = Point(endPoint.x + (offset * cos(des)),endPoint.y + (offset * sin(des)))
        val secondPoint = Point(firstPoint.x + (offsetCather * cos(des + w)),firstPoint.y + (offsetCather * sin(des + w)))
        val triplePoint = Point(firstPoint.x + (offsetCather * cos(des - w)),firstPoint.y + (offsetCather * sin(des - w)))

        println("des $des first $firstPoint second $secondPoint triple $triplePoint")
    }

    companion object{
        private var count = 0

        init {
            count++
            println("Init block")
        }
    }

    fun call() {
        SomeClass()
        SomeObject()
    }
}

private class SomeClass private constructor(){
    companion object{
        operator fun invoke(){
            println("SomeClass invoke")
        }
    }
}

private object SomeObject

private operator fun SomeObject.invoke() {
    println("SomeObject invoke")
}

data class Point(val x: Double, val y: Double)