package ru.roman.task.codility.lessons.a016_greedy_algorithms

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MaxNonoverlappingSegmentsTest {
    private Solution2MaxNonoverlappingSegments subj = new Solution2MaxNonoverlappingSegments()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 3, 7, 9, 9] as int[], [5, 6, 8, 9, 10] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}