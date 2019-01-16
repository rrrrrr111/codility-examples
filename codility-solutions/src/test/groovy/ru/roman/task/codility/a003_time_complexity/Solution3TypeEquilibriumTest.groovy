package ru.roman.task.codility.a003_time_complexity

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3TypeEquilibriumTest {
    private Solution3TypeEquilibrium subj = new Solution3TypeEquilibrium()

    @DataProvider
    private Object[][] provider() {
        [
                [[3, 1, 2, 4, 3] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}