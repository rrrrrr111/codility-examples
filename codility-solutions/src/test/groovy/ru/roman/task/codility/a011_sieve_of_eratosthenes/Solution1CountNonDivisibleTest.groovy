package ru.roman.task.codility.a011_sieve_of_eratosthenes

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1CountNonDivisibleTest {
    private Solution1CountNonDivisible subj = new Solution1CountNonDivisible()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], [0] as int[]],
                [[1, 1, 1, 1, 1] as int[], [0, 0, 0, 0, 0] as int[]],
                [[100_000] as int[], [0] as int[]],
                [[100_000, 100_000, 100_000] as int[], [0, 0, 0] as int[]],
                [[100_000, 100_000, 100_000, 1] as int[], [0, 0, 0, 3] as int[]],
                [[32, 32, 16, 8, 4, 2, 1] as int[], [0, 0, 2, 3, 4, 5, 6] as int[]],
                [[45, 15, 5, 3, 1] as int[], [0, 1, 3, 3, 4] as int[]],
                [[45, 45, 45, 15, 5, 3, 1] as int[], [0, 0, 0, 3, 5, 5, 6] as int[]],
                [[1, 2] as int[], [1, 0] as int[]],
                [[1, 2, 3] as int[], [2, 1, 1] as int[]],
                [[1, 2, 2, 3] as int[], [3, 1, 1, 2] as int[]],
                [[3, 1, 2, 3, 6] as int[], [2, 4, 3, 2, 0] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int[] expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}