package ru.roman.task.gfg.dp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.roman.task.blank.Gfg

@CompileStatic
@Test
class GfgMinimumStepsDeleteTest {
    private GfgMinimumStepsDelete subj = new GfgMinimumStepsDelete()

    @DataProvider
    private Object[][] provider() {
        [
                ["abcddcba", 4],
                ["ccccbbbbbbaaaabbbcccccccc", 3],
                ["eeeeedcccbaabbcddde", 5],
                ["abcdedcbabcdedcba", 9],
                ["edcbabcde", 5],
                ["aaaaaaaaaaaa", 1],
                ["abcdefghijklmnopqrstuvwxyz", 26],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.test(value)
        assert actual == expected
    }
}