import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validParenthesesTest {
    @Test
    void isValidTest() {
        String word = "[]{}[]";
        boolean valid = validParentheses.isValid(word);
        assertEquals(true, valid);
    }
}