public interface Deque<item> {
    public void addFirst(item o);

    public void addLast(item o);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public item removeFirst();

    public item removeLast();

    public item get(int index);
}
