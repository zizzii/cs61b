import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator ofo = new OffByN(5);

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
        assertFalse(palindrome.isPalindrome("flake",ofo));
        assertTrue(palindrome.isPalindrome("afaf",ofo));
        assertTrue(palindrome.isPalindrome("lqlq",ofo));

    }
}
