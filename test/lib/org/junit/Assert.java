package org.junit;

public class Assert {
    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        throw new AssertionError("Expected: " + expected + ", but was: " + actual);
    }

    public static void assertNotNull(Object object) {
        if (object != null)
            return;
        throw new AssertionError("Expected object to be not null");
    }

    public static void assertNull(Object object) {
        if (object == null)
            return;
        throw new AssertionError("Expected object to be null, but was: " + object);
    }

    public static void assertTrue(boolean condition) {
        if (condition)
            return;
        throw new AssertionError("Expected condition to be true");
    }

    public static void assertFalse(boolean condition) {
        if (!condition)
            return;
        throw new AssertionError("Expected condition to be false");
    }
}
