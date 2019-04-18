package ru.roman.task.codility.lessons.a006_sorting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class MinProductOfTwoTest {
    private MinProductOfTwo subj = new MinProductOfTwo()

    @DataProvider
    private Object[][] provider() {
        [
                [[-4, 0, 1, 2, 3] as int[], -12L],
                [[-4, 0, 1, 2, 3, 4] as int[], -16L],
                [[-1, 0, 1, 2, 3, 4] as int[], -4L],
                [[0, 1, 2, 3, 4] as int[], 0L],
                [[2, 3, 4] as int[], 6L],
                [[-4, -3, 0, 1, 2, 3] as int[], -12L],
                [[-4, -3, -2, 0] as int[], 0L],
                [[-4, -3, -2, 0, 1] as int[], -4L],
                [[-4, -3, -2, 0, 1, 1] as int[], -4L],
                [[-4, -3, -2, -1, 1, 2] as int[], -8L],
                [[-4, -3, -4, -2, 0, 1, 1, 1] as int[], -4L],
                [[-4, -3, -2, -1] as int[], 2L],
                [[-4, -3, -2, -1, 0] as int[], 0L],
                [[1, 0, -1, -1, -2, -1, 1, 0, -1, -2, -3, -1, -2, -4] as int[], -4L],
                [[-2, -1, 3, 4] as int[], -8L],
                [[2, -3, 3, 1, -4, 0] as int[], -12L],
                [[-3, -3, -2, 0, 1, 2] as int[], -6L],
                [[-3, 1, 2, -2, 5, 6] as int[], -18L],
                [[4, 7, 3, 2, 1, -3, -5] as int[], -35L],
                [[-4, -6, 3, 4, 5] as int[], -30L],
                [[-3, -3, 0, 1, 2] as int[], -6L],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, long expected) {

        def actual = subj.test(value)
        assert actual == expected
    }
}