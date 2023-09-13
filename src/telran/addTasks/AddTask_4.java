package telran.addTasks;
import java.util.Stack;

public class AddTask_4 {

	public static boolean hasValidBrackets(String str) {
		char[]strArray = str.toCharArray();
		
		Stack<Character> stack = new Stack<>();

		for (char ch : strArray) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty() || !isClosingBracket(stack.pop(), ch)) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}

	private static boolean isClosingBracket(char openBr, char closeBr) {
		return (openBr == '(' && closeBr == ')') ||
			   (openBr == '{' && closeBr == '}') ||
			   (openBr == '[' && closeBr == ']');
	}
}
