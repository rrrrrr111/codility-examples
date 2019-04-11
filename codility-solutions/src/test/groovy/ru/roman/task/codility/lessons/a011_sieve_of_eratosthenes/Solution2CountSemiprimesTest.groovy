package ru.roman.task.codility.lessons.a011_sieve_of_eratosthenes

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2CountSemiprimesTest {
    private Solution2CountSemiprimes subj = new Solution2CountSemiprimes()

    @DataProvider
    private Object[][] provider() {
        [
                [1, [1] as int[], [1] as int[], [0] as int[]],
                [4, [4] as int[], [4] as int[], [1] as int[]],
                [26, [1, 4, 16] as int[], [26, 10, 20] as int[], [10, 4, 0] as int[]],
                [50_000, [1, 25_000] as int[], [50_000, 25_000] as int[], [12110, 0] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int[] value2, int[] value3, int[] expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}