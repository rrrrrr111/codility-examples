package ru.roman.task.codility.lessons.a014_binary_search_algorithm

import groovy.transform.CompileStatic
import org.junit.BeforeClass
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2NailingPlanksWorkLoadTest {
    private Solution2NailingPlanks subj = new Solution2NailingPlanks()

    private static int[] planksStart
    private static int[] planksEnd
    private static int[] nails

    @BeforeClass
    static void setUp() {
        def r = new Random()
        planksStart = new int[30_000]
        planksEnd = new int[30_000]
        nails = new int[30_000]

        for (int i = 0; i < planksStart.length; i++) {
            planksEnd[i] = Math.abs(r.nextInt())
            planksStart[i] = r.nextInt(planksEnd[i] + 1)
            nails[i] = r.nextInt(planksEnd[i] - planksStart[i]) + planksStart[i]
        }
        Collections.shuffle(Arrays.asList(nails), r)
    }

    @DataProvider
    private Object[][] provider() {
        [
                [planksStart, planksEnd, nails],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int[] value3) {

        def r = subj.solution(value1, value2, value3)
        assert r > -1
    }
}