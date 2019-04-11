package ru.roman.task.codility.lessons.a004_counting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2FrogRiverOneTest {
    private Solution2FrogRiverOne subj = new Solution2FrogRiverOne()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 1, 0],
                [[1, 2] as int[], 2, 1],
                [[1, 2, 3] as int[], 3, 2],
                [[1, 2, 2, 3] as int[], 3, 3],
                [[1, 2, 1, 3] as int[], 3, 3],
                [[1, 2, 1, 3, 2, 1, 3, 4, 3, 5, 3] as int[], 3, 3],
                [[6, 6, 6, 6, 6, 4, 5, 4, 3, 2, 1] as int[], 4, 10],
                [[6, 6, 6, 6, 6, 4, 5, 4, 3, 2, 1, 1] as int[], 4, 10],
                [[6, 6, 6, 6, 6, 4, 5, 4, 3, 2, 1, 1, 2] as int[], 4, 10],
                [[1, 1, 1, 3] as int[], 3, -1],
                [[1, 2, 3, 4, 5] as int[], 6, -1],
                [[1, 3, 1, 4, 2, 3, 5, 4] as int[], 5, 6],
                [[1, 3, 1, 1, 2, 3, 5, 1] as int[], 5, -1],
                [[1, 100_000] as int[], 2, -1],
                [[1, 100_000] as int[], 1, 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value2, int value1, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}