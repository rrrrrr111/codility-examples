package ru.roman.task.codility.a002_arrays

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2RotateTest {
    private Solution2Rotate subj = new Solution2Rotate()

    @DataProvider
    private Object[][] provider() {
        [
                [[0, 1, 0, 0] as int[], 1, [0, 0, 1, 0] as int[]],
                [[0, -1, 0, 0] as int[], 2, [0, 0, 0, -1] as int[]],
                [[0, 0, 0, 1] as int[], 1, [1, 0, 0, 0] as int[]],
                [[1, 0, 0, 0] as int[], -1, [0, 0, 0, 1] as int[]],
                [[1, 0, 0, 0] as int[], -5, [0, 0, 0, 1] as int[]],
                [[0, 1, 0, 0, 0] as int[], 7, [0, 0, 0, 1, 0] as int[]],
                [[3, 8, 9, 7, 6] as int[], 3, [9, 7, 6, 3, 8] as int[]],
                [[3, 8, 9, 7, 6] as int[], 8, [9, 7, 6, 3, 8] as int[]],
                [[3, 8, 9, 7, 6] as int[], 108, [9, 7, 6, 3, 8] as int[]],
                [[1, 1, 1] as int[], 1, [1, 1, 1] as int[]],
                [[1, 67, 1] as int[], 0, [1, 67, 1] as int[]],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, int[] expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}