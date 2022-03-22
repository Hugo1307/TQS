package pt.ua.deti.tqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TqsStackTest {

    private TqsStack<String> tqsStack;

    @BeforeEach
    public void setUp() {
        tqsStack = new TqsStack<>();
    }

    @Test
    @DisplayName("A stack is empty on construction.")
    public void testEmptyConstruction() {
        Assertions.assertTrue(tqsStack.isEmpty());
    }

    @Test
    @DisplayName("A stack has size 0 on construction.")
    public void testHasSizeZero() {
        Assertions.assertEquals(0, tqsStack.size());
    }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    public void testNToEmpty() {

        int n = 5;

        for (int i = 0; i < n; i++) {
            tqsStack.push("* " + i);
        }

        Assertions.assertFalse(tqsStack.isEmpty());
        Assertions.assertEquals(n, tqsStack.size());

    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x.")
    public void testPushPop() {

        tqsStack.push("Hey");
        Assertions.assertEquals("Hey", tqsStack.pop());

    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    public void testPushPeek() {

        tqsStack.push("Hey");

        String peekedValue = tqsStack.peek();

        Assertions.assertEquals("Hey", peekedValue);
        Assertions.assertEquals(1, tqsStack.size());

    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    public void testNPopsSize() {

        int n = 5;

        for (int i = 0; i < n; i++) {
            tqsStack.push("Hello");
        }

        Assertions.assertEquals(n, tqsStack.size());

        for (int i = 0; i < n; i++) {
            tqsStack.pop();
        }

        Assertions.assertEquals(0, tqsStack.size());

    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    public void testPoppingEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> tqsStack.pop());
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void testPeekingEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> tqsStack.peek());
    }

    @Test
    @DisplayName("For bounded stacks only:pushing onto a full stack does throw an IllegalStateException")
    public void testFullStack() {

        tqsStack.setLimit(2);

        tqsStack.push("Hey");
        tqsStack.push("Hey");

        Assertions.assertThrows(IllegalStateException.class, () -> tqsStack.push("Hey"));

    }

    @Test
    @DisplayName("Test for 'push()' method")
    public void testPush() {

        tqsStack.push("Hey");
        Assertions.assertFalse(tqsStack.isEmpty());
        Assertions.assertEquals("Hey", tqsStack.peek());

    }

    @Test
    @DisplayName("Test for 'pop()' method")
    public void testPop() {

        tqsStack.push("Hey");
        tqsStack.push("Hey2");

        String poppedElement = tqsStack.pop();

        Assertions.assertEquals("Hey2", poppedElement);
        Assertions.assertEquals(1, tqsStack.size());

    }

    @Test
    @DisplayName("Test for 'peek()' method")
    public void testPeek() {

        tqsStack.push("Hey");

        String peekedElement = tqsStack.peek();

        Assertions.assertEquals("Hey", peekedElement);
        Assertions.assertFalse(tqsStack.isEmpty());

    }

    @Test
    @DisplayName("Test for 'size()' method")
    public void testSize() {

        tqsStack.push("Hey");

        Assertions.assertEquals(1, tqsStack.size());

        tqsStack.pop();

        Assertions.assertEquals(0, tqsStack.size());

        tqsStack.push("Hello");
        tqsStack.push("Hello2");

        Assertions.assertEquals(2, tqsStack.size());

    }

    @Test
    @DisplayName("Test for 'isEmpty()' method")
    public void testIsEmpty() {

        Assertions.assertTrue(tqsStack.isEmpty());
        tqsStack.push("Hey");
        Assertions.assertFalse(tqsStack.isEmpty());

    }

}