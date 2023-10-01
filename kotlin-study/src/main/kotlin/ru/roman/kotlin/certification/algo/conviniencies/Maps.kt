package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // IdentityHashMap
    val ihm = IdentityHashMap<Int, Int>()

    // iterate map, can use break or continue
    for ((k, v) in mapOf<Int, Int>()) {
        break
    }

    for ((i, entry) in mapOf<Int, Int>().entries.withIndex()) {
        break
    }

    // increment/collect counters in map
    val map = HashMap<Char, Int>()
    map['k'] = (map['k'] ?: 0) + 1
    HashMap<Char, MutableSet<Int>>().computeIfAbsent('k') { mutableSetOf() }.add(1)

    // mutable keys
    val keys = map.keys.toMutableSet()

    val c = map.remove('f')

    map.keys.first()

    val array = map.keys.toTypedArray()


}