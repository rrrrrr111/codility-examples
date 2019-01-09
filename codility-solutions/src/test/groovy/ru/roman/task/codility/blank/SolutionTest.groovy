package ru.roman.task.codility.blank

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider

@CompileStatic
//@Test
class SolutionTest {
    private Solution subj = new Solution()

    @DataProvider
    private Object[][] provider() {
        [
                [0, 0],

        ] as Object[][]
    }

    //@Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}