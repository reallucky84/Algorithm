package `baekjoon-kotlin`

//A+B-4
//https://www.acmicpc.net/problem/10951
fun main() {
    with(System.`in`.bufferedReader()) {
        while (true) {
            val str = readLine() ?: break // should do null check
            str.split(" ").let {
                println(it[0].toInt() + it[1].toInt())
            }
        }
    }
}