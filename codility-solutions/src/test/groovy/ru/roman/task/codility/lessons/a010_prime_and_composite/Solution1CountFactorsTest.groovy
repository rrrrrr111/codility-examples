package ru.roman.task.codility.lessons.a010_prime_and_composite

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1CountFactorsTest {
    private Solution1CountFactors subj = new Solution1CountFactors()

    @DataProvider
    private Object[][] provider() {
        [
                [1, 1],
                [2, 2],
                [3, 2],
                [4, 3],
                [5, 2],
                [6, 4],
                [24, 8],
                [Integer.MAX_VALUE, 2],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}