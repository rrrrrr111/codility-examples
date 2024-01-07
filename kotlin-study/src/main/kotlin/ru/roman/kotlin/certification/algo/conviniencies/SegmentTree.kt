package ru.roman.kotlin.certification.algo.conviniencies

class SegmentTreeExample {

    /*  Segment Tree Node Structure:
     *  index 0 - left child Array
     *  index 1 - right child Array
     *  index 2 - informational IntArray ( leftBound, rightBound, middleValue, maxSequence ) */
    lateinit var root: Array<Any?>
    fun lengthOfLIS(nums: IntArray, k: Int): Int {
        val min = 0
        val max = 100000
        root = arrayOf(null, null, intArrayOf(min, max, min + (max - min) / 2, 0))
        for (e in nums)
            root.add(e, root.findMaxSequence(e - k, e - 1) + 1)
        return (root[2] as IntArray)[3]
    }

    fun Array<Any?>.add(element: Int, maxSequence: Int) {
        val inf = this[2]!! as IntArray
        val min = inf[0]
        val max = inf[1]
        val middle = inf[2]
        when {
            min == max -> { /** Nothing */ }

            element <= middle -> {
                var left = this[0] as Array<Any?>?
                if (left == null) {
                    left = arrayOf(null, null, intArrayOf(min, middle, min + (middle - min) / 2, maxSequence))
                    this[0] = left
                }
                left.add(element, maxSequence)
            }

            middle < element -> {
                var right = this[1] as Array<Any?>?
                if (right == null) {
                    right = arrayOf(null, null, intArrayOf(middle + 1, max, middle + 1 + (max - (middle + 1)) / 2, maxSequence))
                    this[1] = right
                }
                right.add(element, maxSequence)
            }
        }
        inf[3] = maxOf(inf[3], maxSequence)
    }

    fun Array<Any?>?.findMaxSequence(from: Int, to: Int): Int {
        this ?: return 0
        val leftChild = this[0] as Array<Any?>?
        val rightChild = this[1] as Array<Any?>?
        val inf = this[2] as IntArray
        val min = inf[0]
        val max = inf[1]
        val middle = inf[2]
        return when {
            to < min -> 0
            (from == min && to == max) || min == max -> inf[3]
            to <= middle -> leftChild.findMaxSequence(from, to)
            middle < from -> rightChild.findMaxSequence(from, to)
            else -> maxOf(leftChild.findMaxSequence(from, middle), rightChild.findMaxSequence(middle + 1, to))
        }
    }

    fun Any?.print(): String =
        when (this) {
            is Array<*> -> this.toList().map { it.print() }.toString()
            is IntArray -> this.contentToString()
            null -> "null"
            else -> error("Illegal")
        }
}