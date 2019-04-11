package ru.roman.task.codility.lessons.a090_2015_challenge

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1LongestPasswordTest {
    private Solution1LongestPassword subj = new Solution1LongestPassword()

    @DataProvider
    private Object[][] provider() {
        [
                ["test 5 a0A pass007 ?xy1", 7],
                ["test 5 a0A ?xy1 pass007", 7],
                ["pass12007 5 a0A ?xy1 pass017", 9],
                ["pass 5 a0A ?xy1 pass017", 7],
                ["pass 5 a0A ?xy1", 3],
                ["pass 5 ?xy1", 1],
                ["5 ?xy1", 1],
                ["pass 5", 1],
                ["5", 1],
                ["pass207 5 a0A ?xy1", 7],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}