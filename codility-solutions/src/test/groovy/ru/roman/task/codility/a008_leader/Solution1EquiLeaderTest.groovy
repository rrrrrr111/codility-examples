package ru.roman.task.codility.a008_leader

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1EquiLeaderTest {
    private Solution1EquiLeader subj = new Solution1EquiLeader()

    @DataProvider
    private Object[][] provider() {
        [
                [[4, 3, 4, 4, 4, 2] as int[], 2],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}