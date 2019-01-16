package ru.roman.task.codility.a007_stacks_and_queues

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3StoneWallTest {
    private Solution3StoneWall subj = new Solution3StoneWall()

    @DataProvider
    private Object[][] provider() {
        [
                [[8, 8, 5, 7, 9, 8, 7, 4, 8] as int[], 7],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}