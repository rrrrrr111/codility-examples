package ru.roman.task.codility.a010_prime_and_composite

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3PeaksTest {
    private Solution3Peaks subj = new Solution3Peaks()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 0],
                [[1, 1] as int[], 0],
                [[1, 2] as int[], 0],
                [[2, 1] as int[], 0],
                [[2, 1, 2] as int[], 0],
                [[1, 2, 1] as int[], 0],
                [[1, 2, 1, 2, 1] as int[], 0],
                [[1, 2, 1, 1, 2, 1] as int[], 2],
                [[1, 2, 1, 1, 2, 1, 1] as int[], 0],
                [[0, Integer.MAX_VALUE, 0, 0, Integer.MAX_VALUE, 0] as int[], 2],
                [[1, 1, 2, 1, 2, 1] as int[], 2],
                [[1, 2, 1, 2, 1, 1] as int[], 2],
                [[2, 1, 1, 1, 2, 1] as int[], 0],
                [[1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1] as int[], 4],
                [[1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}