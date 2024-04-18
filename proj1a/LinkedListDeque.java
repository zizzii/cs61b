public class LinkedListDeque<T> {
    private class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node<T> sentFront;
    private Node<T> sentBack;
    private int size;

    /* Create an empty list */
    public LinkedListDeque() {
        sentFront = new Node<>(null,  null, null);
        sentBack = new Node<>(null, null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T stuff) {
        Node<T> temp = sentFront.next;
        sentFront.next = new Node<>(stuff, sentFront, sentFront.next);
        temp.prev = sentFront.next;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T stuff) {
        Node<T> temp = sentBack.prev;
        sentBack.prev = new Node<>(stuff, sentBack.prev, sentBack);
        temp.next = sentBack.prev;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null.*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T F = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        return F;
    }

    /* Removes and returns the item at the back of the deque.
    If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T L = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        return L;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node<T> ptr = sentFront.next;
        while (ptr != sentBack) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    /*
    Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }
        Node<T> ptr = sentFront.next;
        while (index > 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.item;
    }
    private T getRecursiveHelper(int index, Node<T> ptr) {
        if (index == 0) {
            return ptr.item;
        }
        return getRecursiveHelper(index - 1, ptr.next);
    }
    public T getRecursive(int index) {
        if (index + 1 > size) {
            return null;
        }
        return getRecursiveHelper(index, sentFront.next);
    }

}


