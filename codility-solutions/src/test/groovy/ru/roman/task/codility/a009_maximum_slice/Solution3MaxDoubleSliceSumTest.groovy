package ru.roman.task.codility.a009_maximum_slice

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3MaxDoubleSliceSumTest {
    private Solution3MaxDoubleSliceSum subj = new Solution3MaxDoubleSliceSum()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 1, 1] as int[], 0],
                [[-1, -1, -1] as int[], 0],
                [[10, 10, 10] as int[], 0],
                [[1, 1, 1, 1, 1] as int[], 2],
                [[-1, -1, -1, -1, -1] as int[], 0],
                [[1, 2, 1, 2, 1] as int[], 4],
                [[1, 2, 2, 1, 1] as int[], 4],
                [[1, 1, 2, 2, 1] as int[], 4],
                [[2, 1, 2, 1, 2] as int[], 3],
                [[2, 1, 1, 2, 2] as int[], 3],
                [[2, 2, 1, 1, 2] as int[], 3],
                [[1, 1000, 1, -100, 1] as int[], 1001],
                [[1, -100, 1, -100, 1] as int[], 1],
                [[1, -100, -100, 10, 1] as int[], 10],
                [[-100, 1000, -10, -100, -10, 1000, -100] as int[], 1980],
                [[-100, -5, -10, -100, -10, -5, -100] as int[], 0],
                [[3, 2, 6, -1, 4, 5, -1, 2] as int[], 17],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}