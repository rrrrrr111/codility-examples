package ru.roman.task.gfg.arrays

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class GfgSubArraySumTest {
    private GfgSubArraySum subj = new GfgSubArraySum()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 4, 20, 3, 10, 5] as int[], 33, "2,4"],
                [[10, 2, -2, -20, 10] as int[], -10, "0,3"],
                [[-10, 0, 2, -2, -20, 10] as int[], 20, "-1"],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, String expected) {

        def actual = subj.test(value1, value2)
        assert actual == expected
    }
}