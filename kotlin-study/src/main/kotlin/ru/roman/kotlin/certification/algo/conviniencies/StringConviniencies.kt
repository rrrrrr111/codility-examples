package ru.roman.kotlin.certification.algo.conviniencies

import kotlin.random.Random

fun main() {
    // iterate with indexes, can use break or continue
    for ((i, c) in "word".toCharArray().withIndex()) {
        break
    }

    // search Char from tail
    "word".lastIndexOfAny(charArrayOf('c', 'g'), "word".lastIndex, true)

    // 0-based Char codes
    ('a' + 2).toChar()  // 'c'
    val c: Char = Random.nextInt().toChar()
    c - 'a' // 'a' -> 0, 'c' -> 2, etc

    // sub-string
    String("word".toCharArray().sliceArray(33..44))


}


fun getWordSign(arr: CharArray, from: Int = 0, to: Int = arr.lastIndex): IntArray {
    error("???")
}

fun isPalindrom(arr: CharArray, from: Int = 0, to: Int = arr.lastIndex): Boolean {
    error("???")
}