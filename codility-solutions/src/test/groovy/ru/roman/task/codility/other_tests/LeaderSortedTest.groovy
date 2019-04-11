package ru.roman.task.codility.other_tests

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class LeaderSortedTest {
    private LeaderSorted subj = new LeaderSorted()

    @DataProvider
    private Object[][] provider() {
        [
                [[2, 2, 2, 2, 2, 3, 4, 4, 4, 6] as int[], -1],
                [[1, 1, 1, 1, 50] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}