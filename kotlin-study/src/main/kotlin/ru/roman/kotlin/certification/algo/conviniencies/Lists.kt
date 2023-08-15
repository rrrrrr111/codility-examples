package ru.roman.kotlin.certification.algo.conviniencies

import java.util.LinkedList

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

}