package ru.roman.task.codility.other_tests.geometry

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test


@CompileStatic
@Test
class GirlLivingOnCageTest {
    private GirlLivingOnCage subj = new GirlLivingOnCage()

    @DataProvider
    private Object[][] provider() {
        [
                [-1, 3, 4, 3, "4,2"],
                [1, -4, -3, -4, "-3,-3"],
                [12, -1, 12, 1, "13,1"],
                [-4, 8, -4, 6, "-5,6"],
                [-2, 2, 5, 1, "4,-6"],
                [1, -2, 5, 1, "8,-3"],
                [-5, -19, 13, 5, "17,2"],
                [-3, -5, 0, 4, "3,3"],
                [-3, -5, 3, 13, "6,12"],
                [0, 0, 2, 2, "3,1"],
                [0, 0, 3, 3, "4,2"],
                [0, 0, 9, 9, "10,8"],
                [0, 0, -9, -9, "-10,-8"],
                [0, 0, 9, -9, "8,-10"],
                [0, 0, -9, 9, "-8,10"],
                [0, 0, 9, 3, "10,0"],
                [-5, -19, 10, 1, "14,-2"],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int value3, int value4, String expected) {

        def actual = subj.solution(value1, value2, value3, value4)
        assert actual == expected
    }
}