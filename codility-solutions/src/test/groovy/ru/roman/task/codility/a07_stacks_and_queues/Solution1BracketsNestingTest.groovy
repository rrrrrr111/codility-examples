package ru.roman.task.codility.a07_stacks_and_queues

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1BracketsNestingTest {
    private Solution1BracketsNesting subj = new Solution1BracketsNesting()

    @DataProvider
    private Object[][] provider() {
        [
                ["{", 0],
                ["", 1],
                ["{}", 1],
                ["{[()()]}", 1],
                ["{[()(]}", 0],
                ["{[()()]}}", 0],
                ["{[()())]}", 0],
                ["([)()]", 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}