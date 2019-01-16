package ru.roman.task.codility.a005_prefix_sum

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution4CountDivTest {
    private Solution4CountDiv subj = new Solution4CountDiv()

    @DataProvider
    private Object[][] provider() {
        [
                [6, 11, 2, 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int value3, int expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}