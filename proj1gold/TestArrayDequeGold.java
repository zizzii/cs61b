import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testArray() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 100; i++) {
            if (stdArray.size() == 0) {
                int number = StdRandom.uniform(1000);
                int choice = StdRandom.uniform(2);
                if (choice == 0) {
                    log += "addFirst(" + number + ")\n";
                    testArray.addFirst(number);
                    stdArray.addFirst(number);
                } else {
                    log += "addLast(" + number + ")\n";
                    testArray.addLast(number);
                    stdArray.addLast(number);
                }
            } else {
                int number = StdRandom.uniform(1000);
                int choice = StdRandom.uniform(4);
                if (choice == 0) {
                    log += "addFirst(" + number + ")\n";
                    testArray.addFirst(number);
                    stdArray.addFirst(number);
                } else if (choice == 1) {
                    log += "addLast(" + number + ")\n";
                    testArray.addLast(number);
                    stdArray.addLast(number);
                } else if (choice == 2) {
                    log += "removeFirst()\n";
                    assertEquals(log, stdArray.removeFirst(), testArray.removeFirst());
                } else {
                    log += "removeLast()\n";
                    assertEquals(log, stdArray.removeLast(), testArray.removeLast());
                }
            }

        }
    }
}
