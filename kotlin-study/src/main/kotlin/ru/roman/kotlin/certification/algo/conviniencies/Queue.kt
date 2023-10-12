package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*
import kotlin.properties.Delegates

fun main() {

    // String from LinkedList of Chars
    String(LinkedList<Char>().toCharArray())

    // init
    val deque: Deque<Int> = LinkedList<Int>()
    val queue: Queue<Int> = LinkedList<Int>()

    deque.push(1)    // addFirst( .. )
    deque.add(1)        // addLast( .. )
    deque.poll()        // remove first, null if empty
    deque.pop()         // same as poll, but throws if empty
    deque.peek()        // get first, but does not remove, null if empty
    deque.removeLast()  // remove last

    queue.add(1)
    queue.poll()
    queue.peek()
}
