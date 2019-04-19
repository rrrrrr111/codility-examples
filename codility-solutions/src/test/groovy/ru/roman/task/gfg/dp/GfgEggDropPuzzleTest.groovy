package ru.roman.task.gfg.dp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class GfgEggDropPuzzleTest {
    private GfgEggDropPuzzle subj = new GfgEggDropPuzzle()

    @DataProvider
    private Object[][] provider() {
        [
                [2, 10, 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int expected) {

        def actual = subj.test(value1, value2)
        assert actual == expected
    }
}