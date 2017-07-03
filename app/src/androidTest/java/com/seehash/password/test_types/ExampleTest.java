package com.seehash.password.test_types;

import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class ExampleTest {

    @Test
    @SmallTest
    public void validateSecondActivity() {
        // Do something not so long...

        assertEquals("Small Test run", 100, 100, 0.001);
    }

    @Test
    @MediumTest
    public void validateSecondActivityAgain() {
        // Do something which takes more time....

        assertEquals("Medium Test run", 100, 95, 0.001);
    }

}