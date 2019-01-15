package ru.roman.task.codility.a06_sorting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3TriangleTest {
    private Solution3Triangle subj = new Solution3Triangle()

    @DataProvider
    private Object[][] provider() {
        [
                [[2, 3, 4] as int[], 1],
                [[-2, -3, -4] as int[], 0],
                [[-5, -1, 0, 1, 5] as int[], 0],
                [[2, 4, 5] as int[], 1],
                [[2, 2, 4, 4, 5, 5] as int[], 1],
                [[5, 4, 2] as int[], 1],
                [[-1, -100, 1000, -1000, -5, -4, -2, 5, 4, 2] as int[], 1],
                [[Integer.MIN_VALUE, 0, 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE] as int[], 1],
                [[10, 2, 5, 1, 8, 20] as int[], 1],
                [[10, 50, 5, 1] as int[], 0],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}