package ru.roman.kotlin.certification.algo.conviniencies

fun main() {
    // iterate map, can use break or continue
    for ((k, v) in mapOf<Int, Int>()) {
        break
    }

    // increment counters in map
    val map = HashMap<Char, Int>()
    map['k'] = (map['k'] ?: 0) + 1




}