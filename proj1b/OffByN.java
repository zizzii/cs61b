public class OffByN implements CharacterComparator {

    /** number that are off from */
    private int N;
    /** Constructor */
    public OffByN(int number) {
        this.N = number;
    }

    /** return an object whose equalChars method
     * returns true for characters that are off by N
     * */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }
}
