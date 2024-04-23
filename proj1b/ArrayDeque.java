public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;
    private int length;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        back = 4;
        length = 8;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** resize the list to 2 times the original capacity */
    private void grow() {
        T[] newArray = (T[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != back) {
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = length;
        back = ptr2;
        length *= 2;
        items = newArray;
    }
    /** shrink the original list to x times the original capacity */
    private void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 4;
        while (ptr1 != back) {
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = length / 4;
        back = ptr2;
        length /= 2;
        items = newArray;
    }

    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index, int module) {
        index %= module;
        if (index == module - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /** Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        front = minusOne(front);
        items[front] = item;
        size += 1;

    }

    /** Adds an item of type T to the back of the deque.*/
    @Override
    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        items[back] = item;
        size += 1;
        back = plusOne(back, length);
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        int x = front;
        while (x != back) {
            System.out.print(items[x] + " ");
            x = plusOne(x, length);
        }
    }

    /**
    Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return items[ptr];
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        T temp = items[front];
        front = plusOne(front, length);
        size -= 1;
        return temp;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        back = minusOne(back);
        size -= 1;
        return items[back];
    }

}
