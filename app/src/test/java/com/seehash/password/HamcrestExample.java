package com.seehash.password;


import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class HamcrestExample {

    @Test
    public void addition_isCorrect() throws Exception {

        assertEquals(4, 2 + 2);

        assertThat(2+2,is(4));

        assertThat(2+2,equalTo(4));

        assertThat(2+2,is(equalTo(4)));
    }
}
