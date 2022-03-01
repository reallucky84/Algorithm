package `baekjoon-kotlin`

//A+B-3
//https://www.acmicpc.net/problem/10950
fun main() {
    with(System.`in`.bufferedReader()) {
        val count = readLine().toInt()
        for (i in 0 until count) {
            readLine().split(" ").let {
                println(it[0].toInt() + it[1].toInt())
            }
        }
    }
}