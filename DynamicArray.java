/**
 * file: DynamicArray.java
 * class: CSC210
 * instructor: David Claveau
 * author: Aiden Foster
 * purpose: The purpose of this file is to hold the methods that will help us use a dynamic array and define what it is
 */


public class DynamicArray {

	private int[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 3;

	/**
	 * This is the constructor that helps us create the array object
	 */
	public DynamicArray() {
		array = new int[DEFAULT_CAPACITY];
		size=0;
	}
	
	/**
	 * This is the add method that will be called when we want to add a value to the array
	 * @param value is the value we want to add
	 * time complexity: O(1)
	 */
	public void add(int value) {
		if (size >= array.length)
			resize(2*array.length);
		array[size] = value;
		size++;
	}
	
	/**
	 * This is the method we will use to delete an item on our array
	 * time complexity: O(n)
	 */
	public void dequeue() {
		for(int i=0; i<size;i++) {
			if(i == size-1) {
				array[i] = 0;
			}
			else {
				array[i] = array[i+1];
			}
		}
		size--;
	}
	
	/**
	 * This is a getter method for a value at a certain index
	 * @param index is the index we want the value at
	 * @return this will return the value at given index
	 * time complexity: O(1)
	 */
	public int get(int index) {
		return array[index];
	}
	
	/**
	 * This methods will make the array larger so we can fit more values
	 * @param capacity is the new capacity we will make it
	 * time complexity: O(n)
	 */
	private void resize(int capacity) {
		int temp[] = new int[capacity];
		size = capacity < size ? capacity:size;
		for (int i=0; i < size; i++)
			temp[i] = array[i];
		array = temp;
	}
	
	/**
	 * Getter method for the size of the array
	 * @return the size of the array
	 * time complexity: O(1)
	 */
	public int size() {
		return size;
	}
	
	public int pop() {
		int returnValue = array[size-1];
		array[size-1] = 0;
		size--;
		return returnValue;
	}
	
	/**
	 * The method that lets us know if the array is empty or not
	 * @return Returns true or false if it is empty or not
	 * time complexity: O(1)
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * The method that clears the entire array
	 * time complexity: O(n)
	 */
	public void clear() {
		for(int i=0; i<array.length; i++) {
			array[i] = 0;
		}
		size = 0;
	}
	
	/**
	 * The method that tells the object how to print itself
	 * time complexity: O(n)
	 */
	public String toString() {
		StringBuilder returnPrint = new StringBuilder();
		returnPrint.append("{");
		if(size!=0) {
			for(int i=0; i<size;i++) {
				returnPrint.append(array[i]);
				if(i+1 < size) {
					returnPrint.append(",");
				}
			}
		}
		returnPrint.append("}");
		return returnPrint.toString();
	}
	
	/**
	 * This method compares two objects to see if they are the same
	 * @param toCompare an object we will compare
	 * @return a true or false depending on if they are equal or not
	 * time complexity: O(n)
	 */
	public boolean equals(Object toCompare) {
		if(this == toCompare) {
			return true;
		}
		if(toCompare == null) {
			return false;
		}
		if(getClass() != toCompare.getClass()) {
			return false;
		}
		DynamicArray toCompareTwo = (DynamicArray) toCompare;
		if(size == toCompareTwo.size) {
			for(int i = 0; i < size; i++) {
				if(get(i) != toCompareTwo.get(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
