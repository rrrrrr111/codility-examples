package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // sordet
    val sorted = TreeSet<Int>(compareBy { it }).also { it.addAll(listOf(1, 2, 3)) }

    sorted.pollFirst()

    // aka IdentityHashSet
    val ihs: MutableSet<Throwable> = Collections.newSetFromMap(IdentityHashMap())
}
