package `leetcode-kotlin`

// https://leetcode.com/problems/ugly-number/
fun main(){

}

fun isUgly(n: Int): Boolean {
    if(n == 0){
        return false
    }
    var num = n


    while(num % 2 == 0){
        num /= 2
        println("div 2=$num")

    }
    while(num % 3 == 0){
        num /= 3
        println("div 3=$num")
    }
    while(num % 5 == 0){
        num /= 5
        println("div 5=$num")
    }

    return num == 1
}