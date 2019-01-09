package ru.roman.task.codility.a01_iteration

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1IterationTest {

    private Solution1Iteration subj = new Solution1Iteration()

    @DataProvider
    private Object[][] provider() {
        [
                [1041, 5],
                [-2147483648, 0],
                [2147483647, 0],
                [-2147483647, 30],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}