package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static java.lang.Integer.MAX_VALUE
import static java.lang.Integer.MIN_VALUE

@CompileStatic
@Test
class Solution2AbsDistinctTest {
    private AbsoluteValueSort subj = new AbsoluteValueSort()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], [] as int[]],
                [[1] as int[], [1] as int[]],
                [[2, -2] as int[], [-2, 2] as int[]],
                [[1, -2] as int[], [1, -2] as int[]],
                [[1, 1] as int[], [1, 1] as int[]],
                [[-1, 1] as int[], [-1, 1] as int[]],
                [[0, 0, 0] as int[], [0, 0, 0] as int[]],
                [[-1, -1, 0, 0, 1] as int[], [0, 0, -1, -1, 1] as int[]],
                [[0, 0, 0, 0, 0, 0, 0, 0] as int[], [0, 0, 0, 0, 0, 0, 0, 0] as int[]],
                [[MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE] as int[], [MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE] as int[]],
                [[MIN_VALUE, MIN_VALUE, -1, -1] as int[], [MIN_VALUE, MIN_VALUE, -1, -1] as int[]],
                [[MIN_VALUE, MIN_VALUE + 1, -1, -1, 0] as int[], [MIN_VALUE, MIN_VALUE + 1, -1, -1, 0] as int[]],
                [[0, 0, 1, MAX_VALUE, MAX_VALUE] as int[], [0, 0, 1, MAX_VALUE, MAX_VALUE] as int[]],
                [[1, 2, MAX_VALUE, MAX_VALUE] as int[], [1, 2, MAX_VALUE, MAX_VALUE] as int[]],
                [[-1, 1, 2] as int[], [-1, 1, 2] as int[]],
                [[-1, 0, 2] as int[], [0, -1, 2] as int[]],
                [[-1, 0, 0, 2] as int[], [0, 0, -1, 2] as int[]],
                [[-1, 0, 0, 0, 2] as int[], [0, 0, 0, -1, 2] as int[]],
                [[MAX_VALUE - 1, MAX_VALUE] as int[], [MAX_VALUE - 1, MAX_VALUE] as int[]],
                [[1, -1, 3, 4, -4, 5, 6, 22, -22, -23] as int[], [-1, 1, 3, -4, 4, 5, 6, -22, 22, -23] as int[]],
                [[2, 2, 3, 3, -44, -44, -55, -55] as int[], [2, 2, 3, 3, -44, -44, -55, -55] as int[]],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int[] expected) {

        def actual = subj.absSort(value)
        assert actual == expected
    }
}