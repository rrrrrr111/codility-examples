package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // fold something, returns accumulator
    listOf(1, 2, 3, 4, 5).fold(0) { acc, next -> acc + next } // apply accumulator to 1 2 3 4 5, returns 15
    // same, but goes backward
    listOf(1, 2, 3, 4, 5).foldRight(0) { next, acc -> next + acc } // apply accumulator to 5, 4, 3, 2, 1, returns 15

    // reduce something, just without accumulator
    listOf(1, 2, 3, 4, 5).reduce { i1, i2 -> println(" $i1 $i2 "); i1 + i2 } // goes (1, 2) (3, 3) (6, 4) (10, 5) returns 15
    // same, but goes ass-backward
    listOf(1, 2, 3, 4, 5).reduceRight { i1, i2 -> println(" $i1 $i2 "); i1 + i2 } // goes  (4, 5) (3, 9) (2, 12) (1, 14) returns 15

    // windows - are ephemeral sub-lists, meaning should not be used outside the function
    // dy default step=1,
    listOf(1, 2, 3, 4, 5).windowed(3, 1) { subList -> } // [1, 2, 3], [2, 3, 4], [3, 4, 5]
    listOf(1, 2, 3, 4, 5).windowed(3, 2) { subList -> } // [1, 2, 3], [3, 4, 5]
    listOf(1, 2, 3, 4, 5).windowed(3, 2, true) { subList -> } // [1, 2, 3], [3, 4, 5], [5]

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