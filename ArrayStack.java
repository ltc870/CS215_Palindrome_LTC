import java.util.*;

public class ArrayStack<T> implements StackInterface<T> {

	// Class data fields
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	// Empty Argument Constructor
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	// Preferred Constructor
	public ArrayStack(int initialCapacity) {
		integrityOK = false;
		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	} // end constructor

	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

	/** Ensures that the stack has enough space, if not then it doubles the stack's size */
	private void ensureCapacity() {
		if (topIndex >= stack.length - 1) { // If array is full, double its size
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		} // end if
	} // end ensureCapacity

	
	/** Retrieves this stack's top entry.
    @return  The object at the top of the stack.
    @throws  EmptyStackException if the stack is empty. */
	public T peek() {
		checkIntegrity();
		if (isEmpty())
			throw new EmptyStackException("Stack is empty");
		else
			return stack[topIndex];
	} // end peek

	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() {
		checkIntegrity();
		if (isEmpty())
			throw new EmptyStackException("Stack is empty");
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // end if
	} // end pop

	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty() {
		return topIndex < 0;
	} // end isEmpty

	
	/** Removes all entries from this stack. */
	public void clear() {
		while (topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

	private void checkIntegrity() {
		if (!integrityOK)
			throw new EmptyStackException("ArrayBag object is corrupt.");
	} // end checkIntegrity

	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a stack whose " + "capacity exeeds allowed " + "maximum of " + MAX_CAPACITY);
	} // end checkCapacity

	public void displayStack() {
		checkIntegrity();

		List<T> itemArr = new ArrayList<T>();

		for (T item : stack) {
			if (item != null) {
				itemArr.add(item);
			}
		}
		System.out.println("Items in the stack are: " + itemArr);
	}
}
