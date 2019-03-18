package ru.roman.task.codility.a014_binary_search_algorithm

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2NailingPlanksTest {
    private Solution2NailingPlanks subj = new Solution2NailingPlanks()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], [1] as int[], [1] as int[], 1],
                [[1] as int[], [2] as int[], [2] as int[], 1],
                [[1] as int[], [2] as int[], [1] as int[], 1],
                [[1] as int[], [1] as int[], [2, 4, Integer.MAX_VALUE] as int[], -1],
                [[1, 2] as int[], [2, 3] as int[], [2] as int[], 1],
                [[1, 3] as int[], [2, 4] as int[], [2] as int[], -1],
                [[1, 3] as int[], [2, 4] as int[], [3, 2] as int[], 2],
                [[1, 4, 3] as int[], [2, 4, 3] as int[], [2, 4] as int[], -1],
                [[1, 4, 5, 8] as int[], [4, 5, 9, 10] as int[], [4, 6, 7, 10, 2] as int[], 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int[] value3, int expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}