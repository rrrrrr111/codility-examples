package ru.roman.kotlin.certification.algo

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

fun main() {
    // iterate with indexes, can use break or continue
    for ((i, c) in "word".toCharArray().withIndex()) {
        break
    }

    // search Char from tail
    "word".lastIndexOfAny(charArrayOf('c', 'g'), "word".lastIndex, true)

    // increment counters in map
    val map = HashMap<Char, Int>()
    map['k'] = (map['k'] ?: 0) + 1

    // increment counters in array
    val array = IntArray(3)
    array[0] += 1
    array[2]++

    // coerce value
    1.coerceAtLeast(2)
    1.coerceAtMost(-1)
    1.coerceIn(1..3)

    // range to iterate
    1..100 // inclusive
    1 until 100 // exclusive last
    100 downTo 1 // inclusive reverse

    // prepare
    List(33) { "x" }
    IntArray(33) { 7 }

    // Math funs (import kotlin.math.*)
    min(1, 2)
    max(1, 2)
    abs(-1)

    // 0-based Char codes
    ('a' + 2).toChar()  // 'c'
    val c: Char = Random.nextInt().toChar()
    c - 'a' // 'a' -> 0, 'c' -> 2, etc
}