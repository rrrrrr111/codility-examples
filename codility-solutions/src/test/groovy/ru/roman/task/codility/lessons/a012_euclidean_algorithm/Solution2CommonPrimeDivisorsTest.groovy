package ru.roman.task.codility.lessons.a012_euclidean_algorithm

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2CommonPrimeDivisorsTest {
    private Solution2CommonPrimeDivisors subj = new Solution2CommonPrimeDivisors()

    @DataProvider
    private Object[][] provider() {
        [
                [[16, 64, 264] as int[], [4, 16, 1056] as int[], 3],
                [[15, 10, 9] as int[], [75, 30, 5] as int[], 1],
                [[15, 45, 9] as int[], [75, 75, 5] as int[], 2],
                [[15, 45, 9, 375] as int[], [75, 75, 5, 135] as int[], 3],
                [[Integer.MAX_VALUE, 1] as int[], [Integer.MAX_VALUE, 1] as int[], 2],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}