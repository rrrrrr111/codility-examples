package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class ToeplitzMatrixTest {
    private ToeplitzMatrix subj = new ToeplitzMatrix()

    @DataProvider
    private Object[][] provider() {
        [
                [[[1, 2, 3, 4] as int[],
                  [5, 1, 2, 3] as int[],
                  [6, 5, 1, 2] as int[]] as int[][], true],
                [[[1, 2, 3, 4] as int[],
                  [3, 1, 2, 3] as int[],
                  [6, 5, 1, 2] as int[]] as int[][], false],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[][] value, boolean expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}