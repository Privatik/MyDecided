/*
5 5
**.**
*...*
.....
*...*
**.**
 */

class MainWithReadFromConcole {


    val value = 2

    init {
        println("Private")
    }

    companion object {

        @JvmStatic
        fun accessProtectedField() {
            println("Hello")
        }
    }

    object Single{

        val value = 1

        @JvmStatic
        fun simple() {
            println(10)
        }
    }
}