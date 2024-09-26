package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestHomeWork {

    HomeWork homeWork = new HomeWork();

    @Test
    void test_findMaxSubstring() {
        assertEquals("abcd", homeWork.findMaxSubstring("abcddcba"));
        assertEquals("dcbaX", homeWork.findMaxSubstring("abcddcbaX"));
        assertEquals("fertyue", homeWork.findMaxSubstring("aabbcdsdffertyue"));
        assertEquals("abcderfd", homeWork.findMaxSubstring("abcderfdddddsdweq"));
        assertEquals("aertyui", homeWork.findMaxSubstring("aeaaaertyuiiuiui"));
        assertEquals("", homeWork.findMaxSubstring(""));
        assertThrows(NullPointerException.class, () -> homeWork.findMaxSubstring(null));
    }

    @Test
    void test_check() {
        assertTrue(homeWork.check("The quick brown fox jumps over the lazy dog"));
        assertTrue(homeWork.check("The 121 quick brown fox jumps over the lazy dog"));
        assertFalse(homeWork.check("The "));
        assertFalse(homeWork.check(""));
        assertThrows(NullPointerException.class, () -> homeWork.check(null));
    }
}
