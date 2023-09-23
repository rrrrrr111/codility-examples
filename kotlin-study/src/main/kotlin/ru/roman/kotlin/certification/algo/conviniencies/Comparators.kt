package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {
    var r1 = 0

    // reverse order heap
    val map1 = TreeMap<Int, Comparable<Any?>>(compareBy { it })
    val map2 = TreeMap<Int, Comparable<Any?>>(compareByDescending { it })

    val entries1 = map2.entries.sortedBy { it.value }
    val entries2 = map2.entries.sortedByDescending { it.value }

    // sort array with Comparator
    arrayOf(3,1,2).sortWith( compareBy { it } )

}

data class Foo(val i: Int) : Comparable<Foo> {
    override fun compareTo(other: Foo): Int = i.compareTo(other.i)
}