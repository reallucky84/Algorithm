package `leetcode-kotlin`

import kotlin.math.max

// https://leetcode.com/problems/merge-strings-alternately

fun main() {
    val str1 = "ab"
    val str2 = "qprs"

    println(mergeAlternately(str1, str2))
}

fun mergeAlternately(word1: String, word2: String): String {
    val len1 = word1.length
    val len2 = word2.length

    val len = max(len1, len2)
    val sb = StringBuilder()
    for (i in 0 until len) {
        if(i < len1){
            sb.append(word1[i])
        }
        if(i < len2){
            sb.append(word2[i])
        }
    }
    return sb.toString()

}
