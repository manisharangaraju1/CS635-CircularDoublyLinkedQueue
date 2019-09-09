 class Node{
		int data;
		Node next;
		Node prev;
		public Node(int data) {this.data = data;}
	}
public class LinkedList {
	public static void main(String[] args) {
		Node dummy = new Node(0);
		Node firstElement = new Node(1);
		Node secondElement = new Node(2);
		Node lastElement = new Node(3);
		dummy.next = firstElement;
		firstElement.next = secondElement;
		secondElement.next = lastElement;
		lastElement.next = firstElement;
		lastElement.prev = secondElement;
		secondElement.prev = firstElement;
		firstElement.prev = lastElement;
		System.out.println("Head : " + dummy.data + " Next : "+ dummy.next.data + " Prev : " );
		System.out.println("FirstElement : " + firstElement.data + " Next : "+ firstElement.next.data + " Prev : " + firstElement.prev.data);
		System.out.println("SecondElement : " + secondElement.data + " Next : "+ secondElement.next.data + " Prev : " + secondElement.prev.data);
		System.out.println("ThirdElement : " + lastElement.data + " Next : "+ lastElement.next.data + " Prev : " + lastElement.prev.data);
	}

}
