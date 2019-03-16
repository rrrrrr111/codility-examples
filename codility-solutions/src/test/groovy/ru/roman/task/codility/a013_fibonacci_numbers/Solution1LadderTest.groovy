package ru.roman.task.codility.a013_fibonacci_numbers

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1LadderTest {
    private Solution1Ladder subj = new Solution1Ladder()

    @DataProvider
    private Object[][] provider() {
        [
                [[50_000] as int[], [30] as int[], [890883426] as int[]],
                [[4, 4, 5, 5, 1] as int[], [3, 2, 4, 3, 1] as int[], [5, 1, 8, 0, 1] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int[] expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}