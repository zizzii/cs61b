public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = 0;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** resize the list to 2 times the original capacity */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (front > back) {
            int frontLength = items.length - front;
            System.arraycopy(items, front, a, 0, frontLength);
            System.arraycopy(items, 0, a, frontLength, back + 1);
        } else {
            System.arraycopy(items, front, a, 0, size);
        }

        front = 0;
        back = size - 1;
        items = a;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (front == 0 && items[front] == null) {
            items[front] = item;
            size += 1;
        } else if (front == 0) {
            front = items.length - 1;
            items[front] = item;
            size += 1;
        } else {
            front -= 1;
            items[front] = item;
            size += 1;
        }
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (back == 0 && items[back] == null) {
            items[back] = item;
            size += 1;
        } else {
            back += 1;
            items[back] = item;
            size += 1;
        }
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        printDequeHelper(front);
    }

    private void printDequeHelper(int curr) {
        if (curr == back + 1) {
            return;
        }
        if (curr == items.length - 1) {
            System.out.println(items[curr]);
            printDequeHelper(0);
        } else {
            System.out.println(items[curr]);
            printDequeHelper(curr + 1);
        }

    }

    /**
    Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (size == 0) {
            return null;
        } else if (index > size) {
            return null;
        } else if (back > front) {
            return items[index];
        } else {
            if (index + front < items.length) {
                return items[front + index];
            } else {
                return items[index - back];
            }
        }

    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T a = items[front];
        items[front] = null;
        if (front > back) {
            if (front == items.length - 1) {
                front = 0;
            } else {
                front += 1;
            }
        } else {
            front += 1;
        }
        size -= 1;
        if (checkUsage()) {
            resize(items.length / 2);
        }
        return a;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T a = items[back];
        items[back] = null;
        if (front > back) {
            if (back == 0) {
                back = items.length - 1;
            } else {
                back -= 1;
            }
        } else {
            back -= 1;
        }
        size -= 1;
        if (checkUsage()) {
            resize(items.length / 2);
        }
        return a;
    }

    /** Check if the usage factor is more than 50%, if not halve the array. */
    private boolean checkUsage() {
        final int minim = 16;
        return size < items.length / 4 && size > minim;
    }

}
