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
    // Shifts make multiplication and division
    // Shift Right - make division on 2, with possible truncation like 23 >> 2 == 11 (rounding down)
    // Shift Left  - make multiplication on 2, with possible overflow

    // Logical/Unsigned (>>>) vs Arithmetic (>>) right shift
    // Logical fills empty MSb with 0
    // Arithmetic fills empty MSb with previous value, so the division on 2 still works:
    //  -23 >> 2 == -12 (rounding up)

    // integer => 2-base number (or we say binary ???)
    val v1 = 23423L
    val v2 = -13423L
    //  1 -> 000000000000001
    //  2 -> 000000000000010
    //  3 -> 000000000000011
    //  4 -> 000000000000100
    //  Java's methods read fair 2-compliment notation
    val s1 = java.lang.Long.toBinaryString(v1)  // 101101101111111
    val s2 = java.lang.Long.toBinaryString(v2)  // 1111111111111111111111111111111111111111111111111100101110010001
    //  Kotlin's makes negative 2-base number
    //  Kotlin's also has ULong, to tricky represent bigger positive nums, which trickily coincides with negatives
    val s3 = v2.toString(radix = 2)             // kotlin makes negative 2-base number              -11010001101111
    val s4 = v2.toULong().toString(radix = 2)   // 1111111111111111111111111111111111111111111111111100101110010001

    // 2-base number => decimal
    java.lang.Long.parseLong(s1, 2)       // 23423
    s1.toInt(2)                           // Kotlin's methods work same as Java's (has Java's under the hood)
    s1.toLong(2)
    s1.toBigInteger(2)

    // add leading zeros
    java.lang.Long.toBinaryString(v1)
        .padStart(64, '0')       // 0000000000000000000000000000000000000000000000000101101101111111

    // Convert positive to negative and vise versa
    // Positive -> negative: Invert all bits and add (+) 1
    // Negative -> positive: Invert all bits and subtract (-) 1
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

}

/** Check all bits are 1 */
fun checkAllBitsIs1(num: Int): Boolean = (-1 and num) == -1

/** Read certain bit, idx - backward-based, LSb has 0 index */
fun checkBit(num: Int, idx: Int): Boolean = (1 and (num shr idx)) == 1

/** Calc 1 bits in number */
fun calc1Bits(num: Int): Int {
    var c = if (num >= 0) 0 else 1
    var n = abs(num)
    while (n > 0) {
        if (1 and n == 1)
            c++
        n = n shr 1
    }
    return c
}