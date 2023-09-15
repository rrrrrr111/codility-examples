package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {

    // init Heap
    val heap1 = PriorityQueue<Int>(10)
    // reverse order heap
    val heap2 = PriorityQueue<Int>(10, compareByDescending { it })

    // return null if empty
    heap1.poll()

    heap1.add(112)
    heap1.addAll(emptyList())
    heap1.addAll(emptyArray())

}