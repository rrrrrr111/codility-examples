package ru.roman.task.codility.lessons.a004_counting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution4MaxCountersTest {
    private Solution4MaxCounters subj = new Solution4MaxCounters()

    @DataProvider
    private Object[][] provider() {
        [
                [1, [1] as int[], [1] as int[]],
                [2, [1] as int[], [1, 0] as int[]],
                [1, [2] as int[], [0] as int[]],
                [1, [1, 2] as int[], [1] as int[]],
                [2, [1, 2] as int[], [1, 1] as int[]],
                [2, [1, 3] as int[], [1, 1] as int[]],
                [3, [1, 3] as int[], [1, 0, 1] as int[]],
                [3, [2] as int[], [0, 1, 0] as int[]],
                [3, [2, 4] as int[], [1, 1, 1] as int[]],
                [5, [3, 4, 4, 6, 1, 4, 4] as int[], [3, 2, 2, 4, 2] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int[] value2, int[] expected) {

        int[] actual = subj.solution(value1, value2)
        assert actual == expected
    }
}