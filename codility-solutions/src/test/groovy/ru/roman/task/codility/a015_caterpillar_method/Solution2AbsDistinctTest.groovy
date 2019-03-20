package ru.roman.task.codility.a015_caterpillar_method

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static java.lang.Integer.MAX_VALUE
import static java.lang.Integer.MIN_VALUE

@CompileStatic
@Test
class Solution2AbsDistinctTest {
    private Solution2AbsDistinct subj = new Solution2AbsDistinct()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 1],
                [[1, 1] as int[], 1],
                [[-1, 1] as int[], 1],
                [[0, 0, 0] as int[], 1],
                [[-1, -1, 0, 0, 1] as int[], 2],
                [[0, 0, 0, 0, 0, 0, 0, 0] as int[], 1],
                [[MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE] as int[], 1],
                [[MIN_VALUE, MIN_VALUE, -1, -1] as int[], 2],
                [[MIN_VALUE, MIN_VALUE + 1, -1, -1, 0] as int[], 4],
                [[0, 0, 1, MAX_VALUE, MAX_VALUE] as int[], 3],
                [[1, 2, MAX_VALUE, MAX_VALUE] as int[], 3],
                [[-1, 1, 2] as int[], 2],
                [[-1, 0, 2] as int[], 3],
                [[-1, 0, 0, 2] as int[], 3],
                [[-1, 0, 0, 0, 2] as int[], 3],
                [[MAX_VALUE - 1, MAX_VALUE] as int[], 2],
                [[MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, 0, 0, MAX_VALUE, MAX_VALUE] as int[], 3],
                [[-1, 1] as int[], 1],
                [[-1, -1, 1] as int[], 1],
                [[-2, -1, -1, 1, 2] as int[], 2],
                [[-3, -3, -1, 3, 3] as int[], 2],
                [[-5, -3, -1, 0, 3, 6] as int[], 5],
                [[MIN_VALUE, MAX_VALUE] as int[], 2],
                [[MIN_VALUE + 1, MAX_VALUE] as int[], 1],
                [[-12, -10, -10, -8, -8, -7, -7, -7, -7, -6, -4, -2, 0, 0, 0, 1, 3, 5, 7, 7, 7, 9, 11, 13] as int[], 14],
                [[-5, -4, -3, -2, -1, 6, 7, 8, 9] as int[], 9],
                [[-15, -13, -11, 6, 7, 8, 9, 10] as int[], 8],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}