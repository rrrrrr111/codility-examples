package ru.roman.kotlin.certification.algo.conviniencies

import kotlin.math.abs


/**
 *  LSb - least significant bit, low-order bit
 *  MSb - most significant bit, high-order bit
 *
 * Kotlin Bitwise Operations
 *  Conjunction (and)	            a & b	    a and b
 *  Disjunction (or)	            a | b	    a or b
 *  Exclusive disjunction (xor)	    a ^ b	    a xor b
 *  Inversion	                    ~ a	        a.inv()
 *  Shift Left	                    a << bits   a shl bits
 *  Shift Right	                    a >> bits   a shr bits
 *  Unsigned Shift Right	        a >>> bits  a ushr bits
 *
 */
fun main() {
    var v1 = 23423L
    var v2 = -13423L

    // integer => 2-base number (or we say binary ???)
    //  Java's methods read fair 2-compliment notation
    val s1 = java.lang.Long.toBinaryString(v1)  // 101101101111111
    val s2 = java.lang.Long.toBinaryString(v2)  // 1111111111111111111111111111111111111111111111111100101110010001
    //  Kotlin's makes negative 2-base number
    //  Kotlin's also has ULong, tricky representation of bigger positive nums, which trickily coincides with negatives
    val s3 = v2.toString(radix = 2)             // kotlin makes negative 2-base number              -11010001101111
    val s4 = v2.toULong().toString(radix = 2)   // 1111111111111111111111111111111111111111111111111100101110010001

    // 2-base number => decimal
    java.lang.Long.parseLong(s1, 2)       // 23423
    s1.toInt(2)
    s1.toLong(2)                          // Kotlin's methods work same as Java's (has Java's under the hood)
    s1.toBigInteger(2)

    // add leading zeros
    java.lang.Long.toBinaryString(v1)
        .padStart(64, '0')       // 0000000000000000000000000000000000000000000000000101101101111111

    // Convert positive to negative and vise versa
    //   Java method expects positive representation, so it can not read negative 2-base,
    //   but can read leading '-' char ( Kotlin's ...toString(radix = 2) )
    java.lang.Long.parseLong(s2)               // java.lang.NumberFormatException
    java.lang.Long.parseLong(s3)               // -13423

    // For negative 2-base number, in 2-compliment notation it will be represented with first `1` char,
    //  and kind of completely inverted, so to return negative use [Long.parseUnsignedLong(..)],
    //  pad with zeros in case of positive value
    java.lang.Long.parseUnsignedLong(s2.padStart(64, '0'), 2) // -13423
    // or we can invert all bits, add 1 and negate
    java.lang.Long.parseLong(String(s2.map { if (it == '0') '1' else '0' }.toCharArray()), 2) * -1 - 1 // -13423

    // Read certain bit
    //  - move target bit to LSb position, and if (num & 1) == 1 then LSb is 1 otherwise LSb is 0

    // Check all bits are 1
    //  - if (num and -1) == -1 then all bits are 1
}

private val memo = HashMap<Int, Int>()

/** Calc 1 bits in number */
fun calcOneBits(num: Int): Int {
    val m = memo[num]
    if (m != null)
        return m
    var c = if (num >= 0) 0 else 1
    var n = abs(num)
    while (n > 0) {
        if (1 and n == 1)
            c++
        n = n shr 1
    }
    memo[num] = c
    return c
}