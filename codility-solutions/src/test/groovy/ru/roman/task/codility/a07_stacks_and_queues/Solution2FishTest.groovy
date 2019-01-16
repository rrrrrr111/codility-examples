package ru.roman.task.codility.a07_stacks_and_queues

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2FishTest {
    private Solution2Fish subj = new Solution2Fish()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], [0] as int[], 1],
                [[0] as int[], [0] as int[], 1],
                [[1] as int[], [1] as int[], 1],
                [[2] as int[], [1] as int[], 1],
                [[1, 2] as int[], [1, 0] as int[], 1],
                [[1, 2] as int[], [0, 1] as int[], 2],
                [[1, 2, 3, 4] as int[], [0, 0, 1, 1] as int[], 4],
                [[4, 2, 3, 1] as int[], [0, 0, 1, 1] as int[], 4],
                [[4, 2, 3, 1] as int[], [1, 1, 0, 0] as int[], 1],
                [[4, 3, 2, 1] as int[], [1, 1, 0, 0] as int[], 2],
                [[1, 40, 20, 30, 10, 0] as int[], [1, 1, 1, 0, 0, 0] as int[], 2],
                [[1, 40, 20, 30, 10, 0] as int[], [1, 1, 1, 0, 0, 1] as int[], 3],
                [[1, 40, 20, 30, 10, 50] as int[], [1, 1, 1, 0, 0, 0] as int[], 1],
                [[1, 2, 4, 6, 5, 7, 8, 9, 10, 3] as int[], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1] as int[], 10],
                [[1, 2, 4, 6, 5, 7, 8, 9, 10, 3] as int[], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0] as int[], 10],
                [[1, 2, 40, 6, 5, 70, 8, 9, 10, 3, 0] as int[], [1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1] as int[], 5],
                [[1, 2, 40, 6, 5, 70, 8, 9, 10, 3, 0] as int[], [0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0] as int[], 5],
                [[4, 3, 2, 1, 5] as int[], [0, 1, 0, 0, 0] as int[], 2],
                [[4, 2, 1, 3, 5, 6, 7] as int[], [1, 0, 1, 0, 1, 1, 1] as int[], 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}