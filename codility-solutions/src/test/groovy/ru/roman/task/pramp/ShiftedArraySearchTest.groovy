package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class ShiftedArraySearchTest {
    private ShiftedArraySearch subj = new ShiftedArraySearch()

    @DataProvider
    private Object[][] provider() {
        [
                [[9, 12, 17, 2, 4, 5] as int[], 2, 3],
                [[1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 18] as int[], 10, 8],
                [[9, 10, 11, 13, 18 ,1, 3, 4, 5, 6, 7, 8] as int[], 10, 1],
                [[9, 10, 11, 13, 18 ,1, 3, 4, 5, 6, 7, 8] as int[], 8, 11],
                [[9, 10, 11, 13, 18 ,1, 3, 4, 5, 6, 7, 8] as int[], 9, 0],
                [[18, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13] as int[], 18, 0],
                [[18, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13] as int[], 13, 11],
                [[18, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13] as int[], 10, 9],
                [[3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 18, 2] as int[], 2, 11],
                [[3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 18, 2] as int[], 3, 0],
                [[3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 18, 2] as int[], 4, 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, int expected) {

        def actual = subj.shiftedArrSearch(value1, value2)
        assert actual == expected
    }
}