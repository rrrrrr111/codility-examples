package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class MatrixSpiralCopyTest {
    private MatrixSpiralCopy subj = new MatrixSpiralCopy()

    @DataProvider
    private Object[][] provider() {
        [
                [[[] as int[]] as int[][], [] as int[]],
                [[[1] as int[]] as int[][], [1] as int[]],
                [[
                         [1, 2, 3, 4] as int[],
                         [14, 15, 16, 5] as int[],
                         [13, 20, 17, 6] as int[],
                         [12, 19, 18, 7] as int[],
                         [11, 10, 9, 8] as int[],
                 ] as int[][], [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20] as int[]],
                [[
                         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[],
                         [22, 23, 24, 25, 26, 27, 28, 29, 30, 11] as int[],
                         [21, 20, 19, 18, 17, 16, 15, 14, 13, 12] as int[],
                 ] as int[][], [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30] as int[]],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[][] value, int[] expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}