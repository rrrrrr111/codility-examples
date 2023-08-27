package ru.roman.kotlin.certification.algo.conviniencies

fun main() {
    var v1 = 23423L
    var v2 = -13423L

    // bit string
    val s1 = java.lang.Long.toBinaryString(v1)  // 101101101111111
    val s2 = java.lang.Long.toBinaryString(v2)  // 1111111111111111111111111111111111111111111111111100101110010001

    // add leading zeros
    java.lang.Long.toBinaryString(v1)
        .padStart(64, '0')       // 0000000000000000000000000000000000000000000000000101101101111111

    // from bits to decimal
    java.lang.Long.parseLong(s1, 2) // 23423
    // for negative bin value, in 2-compliment notation it will be represented with first `1` char,
    //  and kind of completely inverted, so to return original decimal use [Long.parseUnsignedLong(..)],
    //  pad with zeros in case of positive value
    java.lang.Long.parseUnsignedLong(s2.padStart(64, '0'), 2) // -13423


}