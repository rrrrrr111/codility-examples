package ru.roman.kotlin.certification.algo.conviniencies


fun main() {
    val arr = intArrayOf(-178, -98, -98, -1, 0, 1, 2, 3, 4, 4, 14, 14, 15, 67, 68, 98, 99)

    arr.sort()
    System.out.printf("Index    : %s, JCL result %s%n", binarySearch(arr, 4), arr.binarySearch(4))
    System.out.printf("Index    : %s, JCL result %s%n", binarySearch(arr, 4333), arr.binarySearch(4333))
    System.out.printf("Index    : %s, JCL result %s%n", binarySearch(arr, -98), arr.binarySearch(-98))

}

fun binarySearch(arr: IntArray, value: Int, beg: Int = 0, end: Int = arr.lastIndex): Int {
    var beg = beg
    var end = end
    var res = -1
    var mid: Int
    while (beg <= end) {
//        mid = (beg + end) / 2
        mid = (beg + end ushr 1) // >>> operator works same as divide on 2

        if (arr[mid] == value) {
            res = mid
            end = mid - 1
        } else if (arr[mid] < value) {
            beg = mid + 1
        } else {
            end = mid - 1
        }
    }
    return res
}