package assignment4;

public class BracketChecker {
	public static boolean isValid(String expression) {
		Stack<Character> stack = new Stack<Character>(expression.length());
		for(int i=0;i<expression.length();i++) {
			char character = expression.charAt(i);
			if(character == '(' || character == '[' || character == '{') {
				stack.push(character);
			}
			else if(character == ')' || character == ']' || character == '}') {
				if(stack.isEmpty()) {
					return false;
				}
				char open = stack.pop();
				if(character == ')' && open != '(') {
					return false;
				}
				if(character == ']' && open != '[') {
					return false;
				}
				if(character == '}' && open != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
