import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator ofo = new OffByOne();
    static Palindrome palindrome = new Palindrome();
    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(ofo.equalChars('a','b'));
        assertTrue(ofo.equalChars('b','a'));
        assertTrue(ofo.equalChars('k','l'));
        assertTrue(ofo.equalChars('&','%'));
        assertTrue(ofo.equalChars('%','&'));
        assertFalse(ofo.equalChars('a','s'));
        assertFalse(ofo.equalChars('b','p'));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertFalse(palindrome.isPalindrome("cat",ofo));
        assertFalse(palindrome.isPalindrome("Aa",ofo));
        assertFalse(palindrome.isPalindrome("sdadsafasfa",ofo));
        assertFalse(palindrome.isPalindrome("racecar",ofo));
        assertTrue(palindrome.isPalindrome("a",ofo));
        assertFalse(palindrome.isPalindrome("AAAA",ofo));
        assertFalse(palindrome.isPalindrome("abba",ofo));
        assertTrue(palindrome.isPalindrome("",ofo));
        assertTrue(palindrome.isPalindrome("flake",ofo));
    }

}
