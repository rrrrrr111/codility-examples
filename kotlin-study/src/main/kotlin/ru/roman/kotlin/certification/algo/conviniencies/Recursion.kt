package ru.roman.kotlin.certification.algo.conviniencies

import java.util.*

fun main() {


}

// ??? ai ro know rillly
fun runRecursionAsStack(x: Int, y: Int): Int {

    val stack = LinkedList<MethodParams>().also { it += MethodParams(x, y) }
    var item = stack.pop()
    while (item != null) {

        item = stack.pop()
    }

    return 1
}

data class MethodParams(
    val x: Int,
    val y: Int,
) {
    var returnRes: Int? = null
}
