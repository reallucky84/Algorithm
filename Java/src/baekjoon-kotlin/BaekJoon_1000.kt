package `baekjoon-kotlin`

fun main(){
    with(System.`in`.bufferedReader()){
        val tmp = readLine().split(" ")
        println(tmp[0].toInt() + tmp[1].toInt())
    }
}