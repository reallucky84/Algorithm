package `baekjoon-kotlin`

//A+B-2
//https://www.acmicpc.net/problem/2558
fun main(){
    with(System.`in`.bufferedReader()){
        val a = readLine().toInt()
        val b = readLine().toInt()
        println(a + b)
    }
}