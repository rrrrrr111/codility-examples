package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class KMessedArraySortTest {
    private KMessedArraySort subj = new KMessedArraySort()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 1, [] as int[]],
                [[1] as int[], 1, [1] as int[]],
                [[1, 4, 5, 2, 3, 7, 8, 6, 10, 9] as int[], 2, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[]],
                [[1, 4, 5, 2, 3, 7, 8, 6, 10, 9] as int[], 3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[]],
                [[6, 1, 4, 11, 2, 0, 3, 7, 10, 5, 8, 9] as int[], 6, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, int[] expected) {

        def actual = subj.test(value1, value2)
        assert actual == expected
    }
}