package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // init ArrayList
    val res = MutableList(10) { false }

    // analog to res.set(0, true)
    res[0] = true

    // iterate with index
    for ((i, e) in res.withIndex()) {
    }

    val list = intArrayOf().sorted().toCollection(LinkedList())

    list.lastOrNull()

    // remove by index
    res.removeAt(0)

    // iterate list with fast remove
    val ll = LinkedList<Int>(listOf(1, 2, 3))
    val iterator = ll.listIterator()
    for (e in iterator) {
        // replace element on the fly
        iterator.remove()
        iterator.add(22)

    }
}