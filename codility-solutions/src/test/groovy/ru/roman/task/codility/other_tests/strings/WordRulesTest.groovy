package ru.roman.task.codility.other_tests.strings

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class WordRulesTest {
    private WordRules subj = new WordRules()

    @DataProvider
    private Object[][] provider() {
        [
                [["P>E", "E>R", "R>U"] as String[], "PERU"],
                [["I>N", "A>I", "P>A", "S>P"] as String[], "SPAIN"],
                [["I>N", "S>P", "A>I", "P>A"] as String[], "SPAIN"],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String[] value1, String expected) {

        def actual = subj.findWord(value1)
        assert actual == expected
    }
}