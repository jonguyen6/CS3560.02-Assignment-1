import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s) {
        // Using a stack to keep track of parentheses
        // Therefore, we need to initialize an array to use
        Stack<Character> stack = new Stack<>();

        // Using a for-loop to traverse through the input string
        for (char c : s.toCharArray()) {
            // if-statements are used alongside the stack to check if it is valid
            // the parentheses is only valid if it closes.
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        // therefore, the function will only return true if the stack is empty.
        return stack.isEmpty();
    }
}
