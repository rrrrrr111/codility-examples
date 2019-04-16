package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class PairsWithSpecificDifferenceTest {
    private PairsWithSpecificDifference subj = new PairsWithSpecificDifference()

    @DataProvider
    private Object[][] provider() {
        [
                [[0, -1, -2, 2, 1] as int[], 1,
                 [[1, 0] as int[], [0, -1] as int[], [-1, -2] as int[], [2, 1] as int[]] as int[][]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int value2, int[][] expected) {

        def actual = subj.findPairsWithGivenDifference(value1, value2)
        assert actual == expected

        println actual
    }
}