package ru.roman.task.codility.lessons.a100_other_сhallenges

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1MissingIntegerTest {
    private Solution1MissingInteger subj = new Solution1MissingInteger()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 3, 6, 4, 1, 2] as int[], 5],
                [[1, 2, 3] as int[], 4],
                [[-1, -3] as int[], 1],
                [[-10, 2, 3] as int[], 1],
                [[1] as int[], 2],
                [[2] as int[], 1],
                [[0] as int[], 1],
                [[-1] as int[], 1],
                [[-100, 1000] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}