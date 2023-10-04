package ru.roman.kotlin.certification.algo.conviniencies

fun main() {
    val arr1 = intArrayOf()
    val arr2 = IntArray(100) { 0 }
    val arr3 = IntArray(100)

    // last element
    arr3.last()

    // index of max value
    arr2.withIndex().maxByOrNull { it.value }?.index

    // sort preserving index, makes List
    val srt: List<IndexedValue<Int>> = arr2.withIndex().sortedByDescending { it.value }

    // iterate with indexes, can use break or continue
    for ((i, c) in arr1.withIndex()) {
        break
    }

    // iterate indices
    for (i in arr1.indices) { }

    // slice
    arr1.sliceArray(33..44)

    // 2 Dimensional Array
    val cache = Array(1000) { Array<Any?>(1000) { null } }
    // array of anything
    val bucks: Array<Any?> = Array(1000) { null }

    // search index
    arr1.indexOf(1)
    arr1.indexOfFirst { it > -1 }
    // search index from tail
    arr1.lastIndexOf(11)
    arr1.indexOfLast { it > 0 }

    // increment counters in array
    arr1[0] += 1
    arr1[2]++

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
    // of specified elements
    intArrayOf().sliceArray(listOf(0, 2, 3))

    // inplace sort - Dual-Pivot Quicksort
    intArrayOf(3, 1, 2).sort()

    // return new sorted List!!
    val sorted = intArrayOf(3, 1, 2).sorted()

}