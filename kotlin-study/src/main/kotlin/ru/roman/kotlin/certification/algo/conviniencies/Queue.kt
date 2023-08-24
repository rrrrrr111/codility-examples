package ru.roman.kotlin.certification.algo.conviniencies

import java.util.Deque
import java.util.LinkedList

fun main() {

    // init
    val deque: Deque<Int> = LinkedList<Int>()

    deque.push(1)    // addFirst( .. )
    deque.poll()        // pollFirst()
    deque.add(1)        // addLast( .. )
}