
 package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = last = fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    private int plusOne(int x){
        return (x + 1) % capacity;
    }

    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else {
            rb[last] = x;
            last = plusOne(last);
            fillCount += 1;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            T t = rb[first];
            rb[first] = null;
            first = plusOne(first);
            fillCount -= 1;
            return t;
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];

    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class ArrayRingBufferIterator implements Iterator<T> {
        private int ptr;
        private int curNum;
        public ArrayRingBufferIterator() {
            ptr = first;
            curNum = 0;
        }
        public boolean hasNext() {
            return ptr < fillCount;
        }
        public T next() {
            T retValue = rb[ptr];
            ptr = plusOne(ptr);
            curNum++;
            return retValue;
        }

    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

}
