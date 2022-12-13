/**
 * file: ArrayQueue.java
 * class: CSC210
 * instructor: David Claveau
 * author: Aiden Foster
 * purpose: The purpose of this file is to show how a queue would be handled while using a dynamic array
 */

public class ArrayQueue implements QueueInterface{

	private DynamicArray queue;
	
	/**
	 * This is the constructor that creates the queue object for us
	 */
	ArrayQueue() {
		queue = new DynamicArray();
	}
	
	ArrayQueue(ArrayQueue queue) {
		DynamicArray QueueOutputOne = new DynamicArray();
		int size = queue.size();
		for(int i=0; i<size;i++) {
			int value = queue.dequeue();
			QueueOutputOne.add(value);
			queue.enqueue(value);
		}
		this.queue = QueueOutputOne;
	}
	
	/**
	 * This method will add the value that is passed in to the array
	 * time complexity: O(1)
	 */
	@Override
	public void enqueue(int value) {
		queue.add(value);
	}

	/**
	 * This method will remove the oldest value 
	 * @return the value of the deleted value
	 * time complexity: O(n)
	 */
	@Override
	public int dequeue() {
		int returnValue = queue.get(0);
		if(queue.isEmpty()) {
			return -1;
		}
		else {
			queue.dequeue();
			return returnValue;
		}
	}

	/**
	 * This method will return the oldest value 
	 * @return the last value 
	 * time complexity: O(1)
	 */
	@Override
	public int peek() {
		if(queue.isEmpty()) {
			return -1;
		}
		return queue.get(0);
	}

	/**
	 * This method returns whether or not the queue is empty or not
	 * time complexity: O(1)
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * This method returns the size of the queue
	 * @return the size
	 * time complexity: O(1)
	 */
	@Override
	public int size() {
		return queue.size();
	}

	/**
	 * This method clears the entire queue
	 * time complexity: O(n)
	 */
	@Override
	public void clear() {
		queue.clear();
	}

	/**
	 * This method tells us how to print the queue
	 * time complexity: O(n)
	 */
	public String toString() {
		return queue.toString();
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
		ArrayQueue toCompareTwo = (ArrayQueue) toCompare;
		
		return queue.equals(toCompareTwo.queue);
	}
}
