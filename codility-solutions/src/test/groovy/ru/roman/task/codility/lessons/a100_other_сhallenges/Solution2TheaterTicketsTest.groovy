package ru.roman.task.codility.lessons.a100_other_сhallenges

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2TheaterTicketsTest {
    private Solution2TheaterTickets subj = new Solution2TheaterTickets()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 2, 1, 1] as int[], 4, 3],
                [[1, 2, 3, 4] as int[], 4, 4],
                [[2, 2, 2, 2] as int[], 4, 1],
                [[2, 2, 1, 2, 2] as int[], 5, 4],
                [[1, 2] as int[], 2, 0],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}