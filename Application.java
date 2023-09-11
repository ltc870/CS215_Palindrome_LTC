import java.util.Scanner;
import java.lang.StringBuilder;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/** Creating new stack collection objects */
		ArrayStack<Character> stack1 = new ArrayStack<Character>();
		ArrayStack<Character> stack2 = new ArrayStack<Character>();
		
		/** Creating a new scanner object */
		Scanner scanner = new Scanner(System.in);
		
		
		/** Testing out methods to stack1 */
		System.out.println("Is stack1 empty?: " + stack1.isEmpty());
		
		stack1.push('a');
		stack1.push('h');
		stack1.push('a');
		
		stack1.displayStack();
		
		/** Checking to see if stack1 is empty */
		System.out.println("Is stack1 empty now?: " + stack1.isEmpty());
		
		/** Using the pop method */
		System.out.println("The item taken from the top: " + stack1.pop());
		
		/** Testing the clear method */
		stack1.clear();
		
		/** Checking to see if stack1 is empty */
		System.out.println("Is stack1 empty now?: " + stack1.isEmpty());
		
		/** End of testing stack1 */
		
		/** Checking to see if stack2 is empty */
		System.out.println("Is the stack empty now?: " + stack2.isEmpty());

		System.out.println("Please enter your sentence");
		String sentence = scanner.nextLine();

		String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();

		/** For loop to iterate through the string and pushing each character to the stack,
		 * also printing out the new character at the top of the stack */
		for (int i = 0; i < cleanedSentence.length(); i++) {
			char character = cleanedSentence.charAt(i);
			stack2.push(character);
			System.out.println("The top character now is: " + stack2.peek());
		}

		
		/** Displaying the stack */
		stack2.displayStack();

		/** Creating a StringBuilder object */
		StringBuilder reversedSentence = new StringBuilder();

		/** While loop that pops the items off of the stack and reverses them */
		while (!stack2.isEmpty()) {
			reversedSentence = reversedSentence.append(stack2.pop());
		}
		
		/** Comparing the strings to see if they match */
		if (cleanedSentence.equals(reversedSentence.toString())) {
			System.out.println(cleanedSentence + " is a palindrome!");
		} else {
			System.out.println(cleanedSentence + " is not a palindrome!");
		}

		scanner.close();
	}

}
