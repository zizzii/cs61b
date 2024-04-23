public class LinkedListDeque<T> implements Deque<T>{
    private static class Node<T> {
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
        sentFront.prev = sentBack;
        sentBack.next = sentFront;
        size = 0;
    }

    /* Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T stuff) {
        Node<T> backTemp = sentFront.prev;
        Node<T> node = new Node<>(stuff, backTemp, sentFront);
        backTemp.next = node;
        sentFront.prev = node;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T stuff) {
        Node<T> frontTemp = sentBack.next;
        Node<T> node = new Node<>(stuff, sentBack, frontTemp);
        frontTemp.prev = node;
        sentBack.next = node;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque.*/
    @Override
    public int size() {
        return size;
    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T F = sentFront.prev.item;
        Node<T> temp = sentFront.prev.prev;
        temp.next = sentFront;
        sentFront.prev = sentFront.prev.prev;
        size -= 1;
        return F;
    }

    /* Removes and returns the item at the back of the deque.
    If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T L = sentBack.next.item;
        Node<T> temp = sentBack.next.next;
        temp.prev = sentBack;
        sentBack.next = sentBack.next.next;
        size -= 1;
        return L;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        Node<T> ptr = sentFront.prev;
        while (ptr != sentBack) {
            System.out.print(ptr.item + " ");
            ptr = ptr.prev;
        }
    }

    /*
    Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    @Override
    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }
        Node<T> ptr = sentFront.prev;
        while (index > 0) {
            ptr = ptr.prev;
            index -= 1;
        }
        return ptr.item;
    }
    private T getRecursiveHelper(int index, Node<T> ptr) {
        if (index == 0) {
            return ptr.item;
        }
        return getRecursiveHelper(index - 1, ptr.prev);
    }
    public T getRecursive(int index) {
        if (index + 1 > size) {
            return null;
        }
        return getRecursiveHelper(index, sentFront.prev);
    }

}


