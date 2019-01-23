package ru.roman.task.codility.a012_euclidean_algorithm

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2CommonPrimeDivisorsTest {
    private Solution2CommonPrimeDivisors subj = new Solution2CommonPrimeDivisors()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}