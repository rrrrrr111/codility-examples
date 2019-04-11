package ru.roman.task.codility.other_tests.strings

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.roman.task.codility.other_tests.strings.Solution1AdjustStrings

@CompileStatic
@Test
class Solution1AdjustStringsTest {
    private Solution1AdjustStrings subj = new Solution1AdjustStrings()

    @DataProvider
    private Object[][] provider() {
        [
                ["", "", "EQUAL"],
                ["a", "a", "EQUAL"],

                ["tent", "test", "REPLACE n s"],
                ["a", "s", "REPLACE a s"],

                ["tent", "ten", "INSERT t"],
                ["tent", "tents", "INSERT s"],

                ["tent", "tnet", "SWAP e n"],
                ["tent", "tetn", "SWAP n t"],
                ["etnt", "tent", "SWAP e t"],

                ["tent", "tentss", "IMPOSSIBLE"],
                ["att", "s", "IMPOSSIBLE"],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value1, String value2, String expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}