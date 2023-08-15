package ru.roman.kotlin.certification.algo.conviniencies

import java.util.HashMap

fun main() {
    // iterate map, can use break or continue
    for ((k, v) in mapOf<Int, Int>()) {
        break
    }

    for ((i, entry) in mapOf<Int, Int>().entries.withIndex()) {
        break
    }

    // increment counters in map
    val map = HashMap<Char, Int>()
    map['k'] = (map['k'] ?: 0) + 1

    // mutable keys
    val keys = map.keys.toMutableSet()

    val c = map.remove('f')

    map.keys.first()

    val array = map.keys.toTypedArray()

}