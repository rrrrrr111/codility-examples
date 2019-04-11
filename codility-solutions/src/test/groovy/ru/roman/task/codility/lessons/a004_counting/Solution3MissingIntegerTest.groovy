package ru.roman.task.codility.lessons.a004_counting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3MissingIntegerTest {
    private Solution3MissingInteger subj = new Solution3MissingInteger()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 3, 6, 4, 1, 2] as int[], 5],
                [[1, 2, 3] as int[], 4],
                [[100, 101] as int[], 1],
                [[-1, -3] as int[], 1],
                [[1, 2, 4] as int[], 3],
                [[-1, 1, 2, 4] as int[], 3],
                [[-1, 0, 2, 4] as int[], 1],
                [[-1, 0, 2, 4] as int[], 1],
                [[-1_000_000, 1_000_000] as int[], 1],
                [[-1, 0, 2] as int[], 1],
                [[-1, 0, 1] as int[], 2],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}