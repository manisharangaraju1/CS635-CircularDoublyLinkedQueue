import com.sun.tools.javac.util.StringUtils;

class QueueNode{
		Process processElement;
		QueueNode next;
		QueueNode prev;
		public QueueNode(Process processElement) {this.processElement = new Process();}
	}
public class CircularLinkedQueue {
	int capacity;
	int nodeIndex;
	QueueNode firstNode;
	QueueNode secondNode;
	QueueNode lastNode;
	QueueNode head; //Always points to first Node
	
	public CircularLinkedQueue() {
		firstNode = new QueueNode(new Process());
		secondNode = new QueueNode(new Process());
		lastNode = new QueueNode(new Process());
		firstNode.next = secondNode;
		secondNode.next = lastNode;
		lastNode.next = firstNode;
		firstNode.prev = lastNode;
		secondNode.prev = firstNode;
		lastNode.prev = secondNode;
		head = firstNode;
		capacity = 3;
		nodeIndex = 0;
	}
	
	public void insertElement(Process processElement) {
		if(getSize() == capacity){
			resize();
		}
		QueueNode traverseNode = head;
		while(traverseNode.next != head) {
			if(traverseNode.next.processElement.name != null && traverseNode.processElement.name == null) {
				traverseNode.processElement.name = processElement.name;
				traverseNode.processElement.cpuTime = processElement.cpuTime;
				traverseNode.processElement.pid = processElement.pid;
				System.out.println("FirstInsert : " + traverseNode.processElement.name);
				return;
			}
			traverseNode = traverseNode.next;
		}
		if(traverseNode.next == head && traverseNode.processElement.name == null) {
			traverseNode.processElement.name = processElement.name;
			traverseNode.processElement.cpuTime = processElement.cpuTime;
			traverseNode.processElement.pid = processElement.pid;
			System.out.println("SecondInsert : " + traverseNode.processElement.name);
			return;
		}
	}

	public void resize() {
		for(int nodeIncreaseCount = 0; nodeIncreaseCount<capacity; nodeIncreaseCount++) {
			QueueNode newElement = new QueueNode(new Process());
			newElement.next = head;
			newElement.prev = head.prev;
			head.prev.next = newElement;
			head.prev = newElement;
			head = newElement;
		}
		capacity *= 2;
	}
	
	public void deleteElement() {
		head.prev.processElement = new Process();
		head = head.prev;
	}
	
	public void displayElements() {
		QueueNode dummy = head;
		while(dummy.next != head) {
			System.out.println(dummy.processElement.name);
			System.out.println(dummy.processElement.pid);
			System.out.println(dummy.processElement.cpuTime);
			System.out.println("\n");
			dummy = dummy.next;
		}
		System.out.println(dummy.processElement.name);
		System.out.println(dummy.processElement.pid);
		System.out.println(dummy.processElement.cpuTime);


		System.out.println("HEAD :" +head.processElement.name);
	}
	public int getSize() {
		int size = 0;
		QueueNode traveseNode = head;
		while(traveseNode.next != head) {
			if(traveseNode.processElement.name != null) {
				size++;
			}
			traveseNode = traveseNode.next;
		}
		if(head.prev.processElement.name == null) return size;
		return size+1;
	}

	public static void main(String[] args) {
		CircularLinkedQueue clq = new CircularLinkedQueue();
		Process processOne = new Process("processOne", 123, 198567);
		Process processTwo = new Process("processTwo", 890, 206567);
		Process processThree = new Process("processThree", 890, 206567);
		Process processFour = new Process("processFour", 890, 206567);
		Process processFive = new Process("processFive", 890, 206567);
		clq.insertElement(processOne);
		clq.insertElement(processTwo);
		clq.insertElement(processThree);
		clq.insertElement(processFour);
		clq.insertElement(processFive);
		clq.insertElement(processFive);
		clq.deleteElement();
		clq.deleteElement();
		clq.deleteElement();
		clq.deleteElement();
		clq.displayElements();
		System.out.println(clq.getSize());
	}

}
