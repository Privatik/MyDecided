/*
5 5
**.**
*...*
.....
*...*
**.**
 */

class MainWithReadFromConcole(){
    private val i = 10
    private val ii = 10

    fun simpleOut(){
        println(o)
        println(i)
        simpleIn()
    }

    companion object{
        private val o = 10

        fun simpleIn(){
            println(o)
        }

        fun accessPrivateField(myClass: MainWithReadFromConcole) {
            println(myClass.i)
        }

        fun accessProtectedField(myClass: MainWithReadFromConcole) {
            println(myClass.ii)
        }
    }
}

object Single{

    fun simple() {
        println(10)
    }
}