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

    /** Given a string, isPalindrome
     * return true if it's a palindrome
     * return false if not
     */
    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /** Given a string,
     * will return true if the word is a palindrome according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc
     * */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }

}
