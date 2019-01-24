package ru.roman.task.codility.a011_sieve_of_eratosthenes

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1CountNonDivisibleTest {
    private Solution1CountNonDivisibleWithSieve subj = new Solution1CountNonDivisibleWithSieve()
    //private Solution1CountNonDivisible subj = new Solution1CountNonDivisible()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], [0] as int[]],
                [[1, 1, 1, 1, 1] as int[], [0, 0, 0, 0, 0] as int[]],
                [[100_000] as int[], [0] as int[]],
                [[100_000, 100_000, 100_000] as int[], [0, 0, 0] as int[]],
                [[100_000, 100_000, 100_000, 1] as int[], [0, 0, 0, 3] as int[]],
                [[32, 32, 16, 16, 8, 8, 8, 4, 2, 1] as int[], [0, 0, 2, 2, 4, 4, 4, 7, 8, 9] as int[]],
                [[32, 32, 16, 8, 4, 2, 1] as int[], [0, 0, 2, 3, 4, 5, 6] as int[]],
                [[45, 15, 5, 3, 1] as int[], [0, 1, 3, 3, 4] as int[]],
                [[45, 45, 45, 15, 5, 3, 1] as int[], [0, 0, 0, 3, 5, 5, 6] as int[]],
                [[45, 9, 5, 3, 1] as int[], [0, 2, 3, 3, 4] as int[]],
                [[1, 2] as int[], [1, 0] as int[]],
                [[1, 2, 3] as int[], [2, 1, 1] as int[]],
                [[1, 2, 2, 3] as int[], [3, 1, 1, 2] as int[]],
                [[3, 1, 2, 3, 6] as int[], [2, 4, 3, 2, 0] as int[]],
                [[132, 66, 44, 33, 22, 12, 11, 6, 4, 3, 2, 1] as int[], [0, 4, 6, 8, 8, 6, 10, 8, 9, 10, 10, 11] as int[]],
                [[132, 66, 44, 33, 22, 12, 11, 6, 4, 3, 2, 1] as int[], [0, 4, 6, 8, 8, 6, 10, 8, 9, 10, 10, 11] as int[]],
                [[200, 100, 50, 40, 25, 20, 10, 8, 5, 4, 2, 1] as int[], [0, 3, 6, 4, 9, 6, 8, 8, 10, 9, 10, 11] as int[]],
                [[95, 132, 134, 29, 3, 75, 55, 163, 139, 121, 112, 133, 30, 89, 33, 182, 12, 164, 15, 138, 68, 81, 169, 4, 13, 184, 102, 19, 198, 190, 23, 85, 28, 63, 125, 33, 140, 11, 35, 164, 81, 84, 120, 96, 77, 7, 146, 194, 196, 133, 72, 73, 139, 135, 23, 47, 73, 103, 163, 101, 6, 165, 87, 104, 45, 86, 78, 155, 21, 110, 36, 140, 8, 56, 69, 128, 11, 92, 42, 57, 96, 192, 97, 192, 34, 185, 73, 38, 150, 183, 2, 54, 155, 69, 49, 2, 9, 124, 197, 200] as int[], [98, 89, 97, 99, 99, 97, 97, 98, 98, 97, 92, 96, 94, 99, 95, 95, 94, 95, 98, 91, 95, 96, 98, 97, 99, 92, 94, 99, 90, 94, 98, 99, 95, 95, 99, 95, 92, 98, 98, 95, 96, 89, 90, 91, 96, 99, 94, 96, 93, 96, 90, 97, 98, 95, 98, 99, 97, 99, 98, 99, 96, 92, 97, 94, 96, 97, 94, 98, 97, 94, 92, 92, 96, 93, 95, 95, 98, 94, 93, 97, 91, 89, 99, 89, 97, 99, 97, 96, 92, 98, 98, 94, 98, 95, 98, 98, 98, 96, 99, 95] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int[] expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}