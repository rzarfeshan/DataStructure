package stack.String;

import stack.CharStack.CharStack;

public class StringReverserApp {
	public static void main(String[] args) {
		String str = "crack";
		StringReverser revObj = new StringReverser(str);
		System.out.println(revObj.doReverse());

		StringReverser bracketChecker = new StringReverser("a{b(c)");
		bracketChecker.checkBracket();
	}
}

class StringReverser {
	private String inputStr;
	private String reverseStr;

	public StringReverser(String str) {
		inputStr = str;
	}

	public String doReverse() {
		int strLength = inputStr.length();
		CharStack stack = new CharStack(strLength);
		for (int i = 0; i < strLength; i++) {
			stack.push(inputStr.charAt(i));
		}
		reverseStr = "";
		while (!stack.isEmpty()) {
			reverseStr += stack.pop();
		}
		return reverseStr;
	}

	boolean checkBracket() {
		int strLength = inputStr.length();
		CharStack stack = new CharStack(strLength);
		for (int i = 0; i < strLength; i++) {
			char ch = inputStr.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(': {
				stack.push(ch);
				break;
			}
			case '}':
			case ']':
			case ')': {
				if (!stack.isEmpty()) {
					if ((ch == ')' && stack.pop() != '(') || (ch == '}' && stack.pop() != '{')
							|| (ch == ']' && stack.pop() != '[')) {
						System.out.println("Error " + "ch" + " at " + i);
						return false;
					}
				} else {
					System.out.println("Error " + "ch" + " at " + i);
					return false;
				}
			}
			default:
				break;
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("Missing closing bracket");
			return false;
		}
		System.out.println("Bracket checker return success");
		return true;
	}
}
