package com.seehash.password;

import junit.framework.TestCase;

public class MathTest extends TestCase {

    protected double fValue1;

    protected double fValue2;

    public void testAdd() {

        fValue1= 2.0;

        fValue2= 3.0;

        double result= fValue1 + fValue2;

        System.out.println("Maths test add");

        System.out.println(result == 5.0);

        assertTrue(result == 5.0);
    }
}