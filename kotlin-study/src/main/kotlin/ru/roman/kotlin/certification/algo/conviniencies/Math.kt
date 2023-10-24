package ru.roman.kotlin.certification.algo.conviniencies

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {

    // calculate sum of all elements from 1 to 100
    (1..100).fold(0) { acc, e -> acc + e }
    // with index
    (1..100).foldIndexed(0) { i, acc, e  -> acc + e }

    // division
    0 / 2 // 0
    1 / 2 // 0
    3 / 2 // 1
    5 / 2 // 2

    // remainder
    0 % 2 // 0
    1 % 2 // 1
    3 % 2 // 1
   -3 % 2 // -1
    5 % 2 // 1
    5.0 % 2 // 1.0

    // min / max
    Int.MAX_VALUE
    Int.MIN_VALUE

    // Native Math funs (import kotlin.math.*)
    min(1, 2)
    max(1, 2)
    abs(-1)

    // Kotlin funs (no imports needed)
    minOf(1, 2)
    maxOf(1, 2)

    println(""" """ + ( -3 % 2))
}
class cc {
    // some lazy calc
    val preMax by lazy(LazyThreadSafetyMode.NONE) { Int.MAX_VALUE / 10 }
}