package dshw12;

public class Node {
	public int data; // data for the node
	public Node nextNode; // reference to the next node in the list
	
	/** Create a node */
	public Node(int data) {
		this(data, null);
	}
	
	/** Create a node that refers to the next node*/
	public Node(int data, Node node) {
		this.data = data;
		nextNode = node;
	}
}
