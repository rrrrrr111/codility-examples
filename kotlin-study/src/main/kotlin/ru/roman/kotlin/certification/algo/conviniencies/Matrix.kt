package ru.roman.kotlin.certification.algo.conviniencies


fun main() {
    val dp: Array<Array<Boolean?>> = Array(12) { Array<Boolean?>(12) { null } }
    matrixToString(dp)
}

fun <T> matrixToString(matrix: Array<Array<T?>>, leftPad: Int = 1): String {
    val b = StringBuilder("  [")
    for (arr in matrix) {
        if (b.length == 3) b.append("[") else b.append("   [")
        for (a in arr) {
            val str = a?.toString() ?: "null"
            var i = 1
            while (str.length + i <= leftPad) {
                b.append(" ")
                i++
            }
            b.append(str)
                .append(", ")
        }
        b.delete(b.length - 2, b.length)
            .append("]").append(System.lineSeparator())
    }
    b.delete(b.length - System.lineSeparator().length, b.length).append("]")
    return b.toString()
}