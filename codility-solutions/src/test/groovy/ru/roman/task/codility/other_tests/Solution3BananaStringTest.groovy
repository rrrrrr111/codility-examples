package ru.roman.task.codility.other_tests

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.roman.task.codility.other_tests.Solution3BananaString

@CompileStatic
@Test
class Solution3BananaStringTest {
    private Solution3BananaString subj = new Solution3BananaString()

    @DataProvider
    private Object[][] provider() {
        [
                ["aaa", 0],
                ["ab", 0],
                ["ba", 1],
                ["baaaaaaa", 1],
                ["bbbbbbba", 1],
                ["banana", 3],
                ["cbaaaalk", 3],
                ["zvvvvvvvvva", 2],
                ["yzvvvvvvvvvab", 4],
                ["vvvvvvaavvvvvv", 2],
                ["vvvvvvzyvvvvvv", 2],
                ["vvvvvvyzvvvvvv", 2],
                ["vvvvvvyvvvvvvbbbbbbxbbbbbbb", 14],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value1, int expected) {

        def actual = subj.solution(value1)
        assert actual == expected
    }
}