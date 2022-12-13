/**
 * file: LinkedList.java
 * class: CSC210
 * instructor: David Claveau
 * author: Aiden Foster
 * purpose: The purpose of this file is to hold the methods that will help us use the linked list and define what it is
 */

public class LinkedList {

	private int size = 0; 
	private Node head = null;
	private Node tail = null;
	
	
	/**
	 * This is the constructor that helps us create the nodes we will use in our linked list
	 */
	static class Node {
		int data; 
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	/**
	 * This is the add method that will be called when we want to add a value to the linked list
	 * @param value is the value we want to add
	 * time complexity: O(1)
	 */
	public void add(int data) {
		Node newNode = new Node(data);
		
		if (head==null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	/**
	 * The method that tells the object how to print itself
	 * time complexity: O(n)
	 */
	public String toString() {
		Node curr = head;
		StringBuilder returnPrint = new StringBuilder();
		returnPrint.append("{");
		while(curr != null) {
			returnPrint.append(curr.data);
			if(curr.next != null) {
				returnPrint.append(",");
			}
			curr = curr.next;
		}
		returnPrint.append("}");
		return returnPrint.toString();
	}
	
	/**
	 * Getter method for the size of the array
	 * @return the size of the array
	 * time complexity: O(1)
	 */
	public int size() {
		return size;
	}
	
	/**
	 * The method that lets us know if the linked list is empty or not
	 * @return Returns true or false if it is empty or not
	 * time complexity: O(1)
	 */
	public boolean isEmpty() {
		if(head == null) 
			return true;
		else 
			return false;
	}
	
	/**
	 * The method that clears the linked list
	 * time complexity: O(1)
	 */
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * This is the method we will use to delete an item on our array
	 * time complexity: O(n)
	 */
	public int pop() {
		Node curr = head;	// do I need this and why
		if(head != null) {
			if(curr.next != null) {
				while(curr.next.next != null) {
					curr = curr.next;
				}
				int returnValue = curr.data;
				curr.next = null;
				size--;
				tail = curr;
				return returnValue;
			}
			else if(curr.next == null) {
				int returnValue = curr.data;
				head = null;
				size--;
				tail = head;
				return returnValue;
			}
		}
		return -1;
	}
	
	/**
	 * This is the method we will use to delete an item on our array
	 * time complexity: O(1)
	 */
	public int dequeue() {
		int returnValue = head.data;
		head = head.next;
		size--;
		return returnValue;
	}
	
	/**
	 * This method returns the tail of the linked list
	 * @param type this tells us if we are looking at a stack or queue
	 * @return returns the peek of the tail or head depending on what we need
	 * time complexity: O(1)
	 */
	public int peek(String type) {
		if(type.equals("stack")) {
			if(head != null) {
				return tail.data;
			}
			return -1;
		}
		else {
			if(head != null) {
				return head.data;
			}
			return -1;
		}
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
		LinkedList toCompareTwo = (LinkedList) toCompare;
		if(size == toCompareTwo.size) {
			Node headOne = head;
			Node headTwo = toCompareTwo.head;
			while(headOne != null && headTwo != null) {
				if(headOne.data != headTwo.data) {
					return false;
				}
				headOne = headOne.next;
				headTwo = headTwo.next;
			}
			return true;
		}
		return false;
	}
}
