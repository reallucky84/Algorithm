package `baekjoon-kotlin`

//A+B
//https://www.acmicpc.net/problem/1000
fun main(){
    with(System.`in`.bufferedReader()){
        val tmp = readLine().split(" ")
        println(tmp[0].toInt() + tmp[1].toInt())
    }
}