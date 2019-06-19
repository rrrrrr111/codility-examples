package ru.roman.task.gfg.string

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class PrintAnagramsOnlyTest {
    private PrintAnagramsOnly subj = new PrintAnagramsOnly()

    @DataProvider
    private Object[][] provider() {
        [
                [["abc", "bac", "abc", "d","et","d","et","zzz"] as String[], 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String[] value, int expected) {

        subj.solution(value)

    }
}