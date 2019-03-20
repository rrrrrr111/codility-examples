package ru.roman.task.codility.a016_greedy_algorithms

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1TieRopesTest {
    private Solution1TieRopes subj = new Solution1TieRopes()

    @DataProvider
    private Object[][] provider() {
        [
                [4, [1, 2, 3, 4, 1, 1, 3] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}