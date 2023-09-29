package ru.roman.kotlin.certification.algo

fun main() {


    IntArray(1).asSequence()
        .windowed(2, 1, false) { sl -> (sl[0] <= sl[1]) to (sl[1] <= sl[0]) }
        .fold(true to true) { acc, next ->
            if (!acc.first && !acc.second)
                return
            (acc.first && next.first) to (acc.second && next.second) }
        .let { it.first || it.second }
}
