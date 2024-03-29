package ru.roman.kotlin.certification.algo.conviniencies

import kotlin.random.Random

fun main() {

    // make an Int from Char
    "a1".last().digitToInt()

    // some trimmage
    "sdfs".trim { it.isLetter() }
    "str".trimEnd { it.isLetterOrDigit() }

    // sub-string search
    "str".indexOf("sub")

    // builder
    val b = StringBuilder("traliva")
    b.append('0')
    b.delete(0, 1)                              // delete 0 until 1
    b.insert(1, 'c')                   // insert some char
    b.delete(b.length - 1, b.length)            // delete last Char
    b.reverse()                                 // reversed in-place
    b.reversed()                                // reversed, makes new instance
    b.get(0)                                    // get char
    String(b.foldIndexed(CharArray(b.length)) { i, acc, c -> acc.also { acc[i] = c /* transform */ } })

    // iterate with indices, can use break or continue
    for ((i, c) in "word".toCharArray().withIndex()) {
        break
    }
    // iterate indices backward
    for (i in "ddd".indices.reversed()) {
    }

    // search Char from tail
    "word".lastIndexOfAny(chars = charArrayOf('c', 'g'), startIndex = "word".lastIndex, ignoreCase = true)

    // 0-based Char codes
    ('a' + 2).toChar()  // 'c'
    val c: Char = Random.nextInt().toChar()
    c - 'a' // 'a' -> 0, 'c' -> 2, etc

    // sub-string of sub-array
    String("word".toCharArray().sliceArray(33..44))

    // sub-strings
    "str".substring(startIndex = 1)
    "str".substring(startIndex = 1, endIndex = "str".lastIndex)
    "str".substringAfter("0", "0 not found")
    "str".substringBefore("0", "0 not found")
    "str".substringAfterLast("0", "0 not found")
    "str".substringBeforeLast("0", "0 not found")
    "str".drop(1)        // tr
    "str".dropLast(2)    // s
}


val cache = HashMap<String, IntArray>()
fun getWordSign(str: String, from: Int = 0, to: Int = str.lastIndex): IntArray {
    cache[str]?.also { return@getWordSign it }
    // abcdefghijklmnopqrstuvwxyz (26 chars)
    val arr = IntArray(26)
    for (i in from..to) {
        arr[str[i] - 'a']++
    }
    cache[str] = arr
    return arr
}


class Palindrom {
    /** simple tabulation
     * @return dpTable to check palindroms, (tail, head) of max Palindrom
     * */
    fun preparePalindromTable(arr: CharArray): Pair<Array<Array<Boolean?>>, Pair<Int, Int>> {
        var max = 0
        var maxI = 0 // tail of max Palindrom
        var maxJ = 0 // head of max Palindrom
        val dp: Array<Array<Boolean?>> = Array(arr.size) { Array<Boolean?>(arr.size) { false } }
        for (i in arr.indices) {
            var j = 0
            while (j <= i) {
                val l = i - j + 1
                val res = when (l) {
                    1 -> true
                    2 -> arr[i] == arr[j]
                    else -> arr[i] == arr[j] &&
                        dp[i - 1][j + 1]!! // check for sub-problem
                }
                dp[i][j] = res
                if (res && l > max) {
                    max = l
                    maxI = i
                    maxJ = j
                }
                j++
            }
        }
        return dp to (maxJ to maxI)
    }

    /** Running with Manacher's Algorithm */
    fun findMaxPalindrom(arr: CharArray): Pair<Int, Int> {
        var max = 0
        var maxTail = 0
        var maxHead = 0
        for (i in arr.indices) {
            val (t1, h1) = getMaxPalindrom(arr, i, i)
            val l1 = h1 - t1 + 1
            if (l1 > max) {
                max = l1
                maxTail = t1
                maxHead = h1
                // println(">>>>>>>>>>>>>>>>> max1 [$t1, $h1]")
            }
            val (t2, h2) = getMaxPalindrom(arr, i, i + 1)
            val l2 = h2 - t2 + 1
            if (l2 > max) {
                max = l2
                maxTail = t2
                maxHead = h2
                // println(">>>>>>>>>>>>>>>>> max2 [$t2, $h2]")
            }

        }
        return maxTail to maxHead
    }

    /** Check with expansion from middle point(s) */
    fun getMaxPalindrom(
        arr: CharArray, middlePoint1: Int, middlePoint2: Int
    ): Pair<Int, Int> {
        var tail = middlePoint1
        var head = middlePoint2
        if (tail < head && (head > arr.lastIndex || arr[tail] != arr[head])) {
            return tail to tail
        }
        while (tail > 0 && head < arr.lastIndex && arr[tail - 1] == arr[head + 1]) {
            tail--
            head++
        }
        return tail to head
    }
}