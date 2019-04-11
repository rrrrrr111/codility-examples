package ru.roman.task.codility.lessons.a009_maximum_slice

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1MaxSliceSumTest {
    private Solution1MaxSliceSum subj = new Solution1MaxSliceSum()

    @DataProvider
    private Object[][] provider() {
        [
                [[0] as int[], 0],
                [[1] as int[], 1],
                [[1, 1] as int[], 2],
                [[-10] as int[], -10],
                [[-10, -1] as int[], -1],
                [[-10, 10, 10, -10] as int[], 20],
                [[-10, 10, -10, 10] as int[], 10],
                [[-1_000_000, 0, 1_000_000] as int[], 1_000_000],
                [[1, 2, 3, 4, 5] as int[], 15],
                [[3, 2, -6, 4, 0] as int[], 5],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}