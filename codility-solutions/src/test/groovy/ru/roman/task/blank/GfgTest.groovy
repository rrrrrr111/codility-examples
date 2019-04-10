package ru.roman.task.blank

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
//@Test
class GfgTest {
    private Gfg subj = new Gfg()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
        ] as Object[][]
    }

    //@Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.test(value)
        assert actual == expected
    }
}