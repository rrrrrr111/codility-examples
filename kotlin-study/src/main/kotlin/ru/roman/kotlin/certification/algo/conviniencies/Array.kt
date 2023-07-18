package ru.roman.kotlin.certification.algo.conviniencies

fun main() {
    // iterate with indexes, can use break or continue
    for ((i, c) in Array<Int>(33) { -1 }.withIndex()) {
        break
    }

    // 2 Dimensional Array
    val cache = Array(1000) { Array<Any?>(1000) { null } }

    // search from tail
    intArrayOf().lastIndexOf(11)

    // increment counters in map
    val map = HashMap<Char, Int>()
    map['k'] = (map['k'] ?: 0) + 1

    // increment counters in array
    val array = IntArray(3)
    array[0] += 1
    array[2]++

    // coerce value
    1.coerceAtLeast(2)
    1.coerceAtMost(-1)
    1.coerceIn(1..3)

    // range to iterate
    1..100 // inclusive
    1 until 100 // exclusive last
    100 downTo 1 // inclusive reverse
    100 downTo 1 step 3 // inclusive reverse, skips 2 after every next

    // prepare
    List(33) { "x" }
    IntArray(33) { 7 }

    // sub-array
    intArrayOf().sliceArray(0..10)


}