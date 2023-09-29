package ru.roman.kotlin.certification.algo.conviniencies


fun main() {
    // create
    val dp: Array<Array<Boolean?>> = Array(12) { Array<Boolean?>(12) { null } }

    // log
    matrixToString(dp)

    // iterate through matrix
    l@ for (row in dp) {
        for (e in row) {
            break@l  // break outer loop
        }
    }
    // iterate through matrix with indices
    l@ for ((i, row) in dp.withIndex()) {
        for ((j, e) in row.withIndex()) {
            break@l  // break outer loop
        }
    }


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