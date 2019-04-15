package ru.roman.task.gfg.dp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class GfgPalindromePartitioningTest {
    private GfgPalindromePartitioning subj = new GfgPalindromePartitioning()

    @DataProvider
    private Object[][] provider() {
        [
                ["ababbbabbababa", 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.test(value)
        assert actual == expected
    }
}