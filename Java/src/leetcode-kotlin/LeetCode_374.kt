package `leetcode-kotlin`

// https://leetcode.com/problems/guess-number-higher-or-lower/
const val pick = 6
const val n = 10

fun main(){
    println(guessNumber(n))
}

fun guessNumber(n:Int):Int {
    var low = 1
    var high = n
    var m = low + (high-low)/2
    println("m=$m")

    var g = guess(m)
    println("g=$g")

    while(g != 0){
        if(g == -1){ //pick lower
            high = m
            m = low + (high-low)/2
        } else if(g == 1){ // pick higher
            if(low == m){
                low++
            } else{
                low = m
            }
            m = low + (high-low)/2
        } else {
            break;
        }
        println("m=$m g=$g")
        g = guess(m)
    }

    return m
}


private fun guess(num: Int): Int{
    return when {
        num > pick -> -1
        num < pick -> 1
        else -> 0
    }
}
