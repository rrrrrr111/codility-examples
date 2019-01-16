package ru.roman.task.codility.a006_sorting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1DistinctTest {
    private Solution1Distinct subj = new Solution1Distinct()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
                [[0] as int[], 1],
                [[0, 1] as int[], 2],
                [[1, 0] as int[], 2],
                [[1, 0, 3] as int[], 3],
                [[1, 0, 3, 3, 3, 3, 3, 1] as int[], 3],
                [[2, 1, 1, 2, 3, 1] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}