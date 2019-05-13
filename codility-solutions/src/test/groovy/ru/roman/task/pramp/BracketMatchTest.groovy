package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class BracketMatchTest {
    private BracketMatch subj = new BracketMatch()

    @DataProvider
    private Object[][] provider() {
        [
                ["(", 1],
                ["", 0],
                ["()", 0],
                [")))))", 5],
                ["(((((", 5],
                ["((()()))", 0],
                ["(((()())", 2],
                [")())))", 4],
                ["((()())))", 1],
                [")))(((", 6],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}