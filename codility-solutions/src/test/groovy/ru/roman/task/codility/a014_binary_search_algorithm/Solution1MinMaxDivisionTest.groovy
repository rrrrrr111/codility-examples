package ru.roman.task.codility.a014_binary_search_algorithm

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1MinMaxDivisionTest {
    private Solution1MinMaxDivision subj = new Solution1MinMaxDivision()

    @DataProvider
    private Object[][] provider() {
        [
                [1, 100_000, [100_000] as int[], 100_000],
                [1, 100_000, [1,1,1,1,1] as int[], 5],
                [5, 100_000, [1,1,1,1,1] as int[], 1],
                [4, 100_000, [1,1,1,1,1] as int[], 2],
                [3, 5, [2, 1, 5, 1, 2, 2, 2] as int[], 6],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int[] value3, int expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}