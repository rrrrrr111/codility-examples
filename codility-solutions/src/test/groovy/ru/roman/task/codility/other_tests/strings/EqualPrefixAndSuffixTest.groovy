package ru.roman.task.codility.other_tests.strings

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class EqualPrefixAndSuffixTest {
    private EqualPrefixAndSuffix subj = new EqualPrefixAndSuffix()

    @DataProvider
    private Object[][] provider() {
        [
                ["codility", 0],
                ["", 0],
                ["a", 0],
                ["aa", 1],
                ["bb", 1],
                ["bbb", 2],
                ["bbbb", 3],
                ["abbabba", 4],
                ["zdztratratrazdz", 3],
                ["1zdztratratrazdz", 0],
                ["zydtratratrazyd", 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}