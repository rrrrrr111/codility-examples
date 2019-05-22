package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class DecryptMessageTest {
    private DecryptMessage subj = new DecryptMessage()

    @DataProvider
    private Object[][] provider() {
        [
                ["dnotq", "crime"],
                ["flgxswdliefy", "encyclopedia"],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, String expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}