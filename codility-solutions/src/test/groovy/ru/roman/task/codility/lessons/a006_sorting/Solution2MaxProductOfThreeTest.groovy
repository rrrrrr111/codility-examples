package ru.roman.task.codility.lessons.a006_sorting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MaxProductOfThreeTest {
    private Solution2MaxProductOfThree subj = new Solution2MaxProductOfThree()

    @DataProvider
    private Object[][] provider() {
        [
                [[-4, 0, 1, 2, 3] as int[], 6],
                [[-4, 0, 1, 2, 3, 4] as int[], 24],
                [[-1, 0, 1, 2, 3, 4] as int[], 24],
                [[0, 1, 2, 3, 4] as int[], 24],
                [[2, 3, 4] as int[], 24],
                [[-4, -3, 0, 1, 2, 3] as int[], 36],
                [[-4, -3, -2, 0] as int[], 0],
                [[-4, -3, -2, 0, 1] as int[], 12],
                [[-4, -3, -2, 0, 1, 1] as int[], 12],
                [[-4, -3, -2, -1, 1, 2] as int[], 24],
                [[-4, -3, -4, -2, 0, 1, 1, 1] as int[], 16],
                [[-4, -3, -2, -1] as int[], -6],
                [[-4, -3, -2, -1, 0] as int[], 0],
                [[-4, -3, -2, -1, 0, 1] as int[], 12],
                [[-2, -1, 3, 4] as int[], 8],
                [[2, -3, 3, 1, -4, 0] as int[], 36],
                [[-3, -3, -2, 0, 1, 2] as int[], 18],
                [[-3, 1, 2, -2, 5, 6] as int[], 60],
                [[4, 7, 3, 2, 1, -3, -5] as int[], 105],
                [[-4, -6, 3, 4, 5] as int[], 120],
                [[-3, -3, 0, 1, 2] as int[], 18],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}