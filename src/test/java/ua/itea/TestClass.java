package ua.itea;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestClass {

    @Test
    public void testMethod() {
        assertFalse("false", false);
        assertTrue("true", true);
        assertEquals("assert", "assert");
    }
}