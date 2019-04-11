package ru.roman.task.codility.lessons.a015_caterpillar_method

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1CountDistinctSlicesTest {
    private Solution1CountDistinctSlices subj = new Solution1CountDistinctSlices()

    @DataProvider
    private Object[][] provider() {
        [
                [1, [1] as int[], 1],
                [1, [1, 1] as int[], 2],
                [2, [1, 2] as int[], 3],
                [0, [0, 0] as int[], 2],
                [100_000, [99_000, 100_000] as int[], 3],
                [6, [3, 4, 5, 5, 2] as int[], 9],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}