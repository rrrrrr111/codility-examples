package ru.roman.task.gfg.dp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.roman.task.gfg.blank.Gfg

@CompileStatic
@Test
class GfgKnapsackProblemTest {
    private GfgKnapsackProblem subj = new GfgKnapsackProblem()

    @DataProvider
    private Object[][] provider() {
        [
                [[60, 100, 120] as int[], [10, 20, 30] as int[], 50, "220 [20, 30]"],
                [[40, 100, 50, 60] as int[], [20, 10, 40, 30] as int[], 60, "200 [10, 20, 30]"],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int value3, String expected) {

        def actual = subj.test(value1, value2, value3)
        assert actual == expected
    }
}