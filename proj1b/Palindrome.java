public class Palindrome {
    /** Given a String, wordToDeque return a Deque
     * where the characters appear in the same order
     * as in the String
     * */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /** Helper function to transform Deque to String */
    private String dequeToWord(Deque<Character> d) {
        String s = null;
        int size = d.size();
        for (int i = 0; i < size; i++) {
            s += d.removeFirst();
        }
        return s;
    }

    /** Given a string, isPalindrome
     * return true if it's a palindrome
     * return false if not
     */
    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d);
    }

    /** Helper function to find palindrome */
    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        } else {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (first == last) {
                return isPalindromeHelper(d);
            } else {
                return false;
            }
        }
    }

    /** Given a string,
     * will return true if the word is a palindrome according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc
     * */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }
    /** Helper function */
    private boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (cc.equalChars(first, last)) {
                return isPalindromeHelper(d, cc);
            } else {
                return false;
            }
        }
    }
}
