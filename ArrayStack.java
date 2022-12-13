/**
 * file: ArrayStack.java
 * class: CSC210
 * instructor: David Claveau
 * author: Aiden Foster
 * purpose: The purpose of this file is to show how a stack would be handled while using a dynamic array
 */

public class ArrayStack implements StackInterface {

	private DynamicArray stack;
	
	/**
	 * This is the constructor that creates the stack object for us
	 */
	ArrayStack() { 
		stack = new DynamicArray();
	}
	
	ArrayStack(ArrayStack stack) {
		DynamicArray stackOutputBackwards = new DynamicArray();
		DynamicArray stackOutputTwo = new DynamicArray();
		
		while(!stack.isEmpty()) {
			int value = stack.pop();
			stackOutputBackwards.add(value);
		}
		while(!stackOutputBackwards.isEmpty()) {
			int value = stackOutputBackwards.pop();
			stack.push(value);
			stackOutputTwo.add(value);
		}
		this.stack = stackOutputTwo;
	}

	/**
	 * This method will add the value that is passed in to the array
	 * time complexity: O(1)
	 */
	@Override
	public void push(int value) {
		stack.add(value);
	}

	/**
	 * This method will remove the last value added
	 * @return the value of the deleted value
	 * time complexity: O(1)
	 */
	@Override
	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int returnValue = stack.get(stack.size()-1);
		stack.pop();
		return returnValue;
	}

	/**
	 * This method will return the last value added
	 * @return the last value 
	 * time complexity: O(1)
	 */
	@Override
	public int peek() {
		if(stack.isEmpty()) {
			return -1;
		}
		return stack.get(stack.size()-1);
	}

	/**
	 * This method returns whether or not the stack is empty or not
	 * time complexity: O(1)
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * This method returns the size of the stack
	 * @return the size
	 * time complexity: O(1)
	 */
	@Override
	public int size() {
		return stack.size();
	}

	/**
	 * This method clears the entire stack
	 * time complexity: O(n)
	 */
	@Override
	public void clear() {
		stack.clear();
	}
	
	/**
	 * This method tells us how to print the stack
	 * time complexity: O(n)
	 */
	public String toString() {
		return stack.toString();
	}
	
	/**
	 * This method allows us to compare two objects and see if they are the same
	 * @param toCompare is the object we will compare
	 * @return true or false if it is equal or not
	 * time complexity: O(n)
	 */
	public boolean equals(Object toCompare) {
		if(this == toCompare) {
			return true;
		}
		if(toCompare == null) {
			return false;
		}
		if(this.getClass() != toCompare.getClass()) {
			return false;
		}
		ArrayStack toCompareTwo = (ArrayStack) toCompare;
		
		return stack.equals(toCompareTwo.stack);
	}
}
