package dshw12;

public class SingleLinkedList {
	private Node head, tail;
	
	/** Create a list */
	public SingleLinkedList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	/** Add an element to the beginning of the list */
	public void addToHead(int newData) {
		head = new Node(newData, head);
		if(isEmpty())
			tail = head; // the new node is the only node in the list
	}
	
	/** Add an element to the end of the list */
	public void addToTail(int newData) {
		if(!isEmpty()) {
			tail.nextNode = new Node(newData); // create and link the new node with the last node
			tail = tail.nextNode; // point the tail to the last node
		}
		else
			head = tail = new Node(newData); // the new node is the only node in the list
	}
	
	/** Remove the head node and return the data of the removed node. */
	public int deleteFromHead() {
		int deleted = head.data;
		
		if(head == tail) // if there is only one node
			head = tail = null; // clear the list
		else
			head = head.nextNode; // point the head to the second node
		
		return deleted; // return the data of the removed node
	}
	
	/** Remove the last node and return the data of the removed node. */
	public int deleteFromTail() {
		int deleted = tail.data;
		
		if(head == tail) // if there is only one node
			head = tail = null; // clear the list
		else {
			Node temp;
			for(temp = head; temp.nextNode != tail; temp = temp.nextNode); // find the second last node
			tail = temp; // point the tail to the second last node
			tail.nextNode = null; // link the tail to null
		}
		
		return deleted; // return the data of the removed node
	}

	/** Clear the list */
	public void clear() {
		head = tail = null;
	}
	
	/** Return the index of the head matching element in the list. Return -1 if no match. */
	public int indexOf(int element) {
		Node temp;
		int index = 1; // the index start from 1
		for(temp = head; temp != null && temp.data != element; temp = temp.nextNode, index++); // find the element and get the index
		
		return (temp != null? index : -1); // return the index
	}
	
	/** Print the list */
	public String print() {
		if (isEmpty()) // if the list is empty
			return "Empty List";
		
		StringBuilder string = new StringBuilder(); // build a string for the result
	    Node temp = head;
	    
		for(temp = head; temp != null; temp = temp.nextNode) {
			string.append(temp.data);
			if(temp.nextNode != null)
				string.append(" -> "); // separate two elements with an arrow
		}
		
		return string.toString(); // return the result
		
	}
}
