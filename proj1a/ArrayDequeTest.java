import static org.junit.Assert.*;

import org.junit.Test;
public class ArrayDequeTest {
    @Test
    public void testAddAndGetLast() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(3);
        a.addFirst(2);
        a.addLast(4);
        a.addFirst(1);
        a.addLast(5);
        int B = a.get(3);
        Integer C = a.get(6);
        int D = a.get(0);
        int A = a.get(1);
        assertEquals(A, 2);
        assertEquals(B, 4);
        assertNull(C);
        assertEquals(D, 1);
        a.printDeque();
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> T = new ArrayDeque<>();
        T.addFirst(3);
        T.addFirst(2);
        T.addLast(4);
        T.addFirst(1);
        T.addLast(5);
        System.out.println("Before Removal: ");
        T.printDeque();
        T.removeFirst();
        T.removeFirst();
        T.removeLast();
        T.removeLast();
        System.out.println("After Removal: ");
        T.printDeque();
    }


    @Test
    public void checkUsageTest() {
        ArrayDeque<Integer> T = new ArrayDeque<>();
        for (int i = 100; i >= 0; i--) {
            T.addFirst(i);
        }
        for (int i = 100; i >= 16; i--) {
            T.removeFirst();
        }
        assertTrue(T.size() >= 16);
    }
}
