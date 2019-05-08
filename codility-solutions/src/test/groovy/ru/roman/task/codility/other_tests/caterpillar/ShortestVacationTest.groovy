package ru.roman.task.codility.other_tests.caterpillar

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class ShortestVacationTest {
    private ShortestVacation subj = new ShortestVacation()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 1],
                [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[], 10],
                [[10, 9, 8, 7, 6, 5, 4, 3, 2, 1] as int[], 10],
                [[1, 2, 3, 3] as int[], 3],
                [[1, 1, 2, 3] as int[], 3],
                [[1, 1, 2, 3, 3] as int[], 3],
                [[1, 3, 2, 1, 3] as int[], 3],
                [[1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1] as int[], 3],
                [[1, 0, 0, 0, 0, 0, 3, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1, 0, 0, 0, 0, 0, 1] as int[], 4],
                [[3, 7, 3, 1, 3, 4, 1] as int[], 5],
                [[2, 1, 1, 3, 2, 1, 1, 3] as int[], 3],
                [[7, 5, 2, 7, 2, 7, 4, 7] as int[], 6],
                [[1, 1, 1, 2, 3, 3, 1, 1, 1] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}