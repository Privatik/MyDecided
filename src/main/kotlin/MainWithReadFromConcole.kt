/*
5 5
**.**
*...*
.....
*...*
**.**
 */


fun main(){
   readLine()!!.split(" ").also { nAndm ->
       val n = nAndm[0].toInt()
       val m = nAndm[1].toInt()

       val list = Array(m) {0}

       for (i in 0 until n){
           for (j in 0 until m){
               var isAdd = false

               if (i != 0){
                   val value = list[j]
                   if (value != 0){
                       list[j] = value - 1
                       isAdd = true
                   }
               }

               if (j != 0){
                   val value = list[j - 1]
                   if (value != 0){
                       list[j] = value + 1
                       isAdd = true
                   }
               }

               if (!isAdd && list[j] != 0){
                   list[j]++
               } else if (list[j] != 0){

               }
           }
       }

   }
}