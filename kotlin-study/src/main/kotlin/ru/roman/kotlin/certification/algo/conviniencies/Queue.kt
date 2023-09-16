package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*
import kotlin.properties.Delegates

fun main() {

    // init
    val deque: Deque<Int> = LinkedList<Int>()
    val queue: Queue<Int> = LinkedList<Int>()

    deque.push(1)    // addFirst( .. )
    deque.add(1)        // addLast( .. )
    deque.poll()        // pollFirst()
    deque.peek()        // get first, but does not remove

    queue.add(1)
    queue.poll()
    queue.peek()
}
