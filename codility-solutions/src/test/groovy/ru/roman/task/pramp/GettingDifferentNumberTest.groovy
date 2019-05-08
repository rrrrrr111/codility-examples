package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static java.lang.Integer.MAX_VALUE

@CompileStatic
@Test
class GettingDifferentNumberTest {
    private GettingDifferentNumber subj = new GettingDifferentNumber()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
                [[1] as int[], 0],
                [[0, 1, 2, 3] as int[], 4],
                [[3, 2, 1] as int[], 0],
                [[0, 3, 1, 2] as int[], 4],
                [[MAX_VALUE, MAX_VALUE - 1] as int[], 0],
                [[1000, 1, 0, 1001, 2, 4] as int[], 3],
                [[5, 1, 0, 3, 6, 2, 4] as int[], 7],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.getDifferentNumber(value)
        assert actual == expected
    }
}