import kotlin.math.*

class Arrow {

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
}

data class Point(val x: Double, val y: Double)