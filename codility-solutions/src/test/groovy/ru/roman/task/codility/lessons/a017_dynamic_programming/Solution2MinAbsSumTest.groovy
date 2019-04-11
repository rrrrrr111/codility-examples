package ru.roman.task.codility.lessons.a017_dynamic_programming

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MinAbsSumTest {
    private Solution2MinAbsSum subj = new Solution2MinAbsSum()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
                [[1] as int[], 1],
                [[1, 1] as int[], 0],
                [[1, 5, 2, -2] as int[], 0],
                [[10, 20, 30, 0] as int[], 0],
                [[2, 2, 3, 3, 3, 7, 7, 7, 7] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}