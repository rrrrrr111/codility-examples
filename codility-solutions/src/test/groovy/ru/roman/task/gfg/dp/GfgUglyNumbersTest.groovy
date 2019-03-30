package ru.roman.task.gfg.dp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class GfgUglyNumbersTest {
    private GfgUglyNumbers subj = new GfgUglyNumbers()

    @DataProvider
    private Object[][] provider() {
        [
                [1, 1],
                [6, 6],
                [7, 8],
                [10, 12],
                [15, 24],
                [150, 5832],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.test(value)
        assert actual == expected
    }
}