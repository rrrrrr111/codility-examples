package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // Sorted Maps
    val map1 = TreeMap<Int, Comparable<Any?>>(compareBy { it })
    val map2 = TreeMap<Int, Comparable<Any?>>(compareByDescending { it })
    val map3 = TreeMap<Int, Int>(Collections.reverseOrder())
    val map4 = TreeMap<Int, Int>(Collections.reverseOrder(compareBy<Int> { it }))

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

    val c: Int? = map.remove('f')

    map.keys.first()

    val array = map.keys.toTypedArray()
}