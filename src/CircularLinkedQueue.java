 class QueueNode{
		Process processElement;
		QueueNode next;
		QueueNode prev;
		public QueueNode(Process processElement) {this.processElement = new Process();}
	}
public class CircularLinkedQueue {
	int capacity;
	QueueNode firstNode;
	QueueNode secondNode;
	QueueNode lastNode;
	
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
		capacity = 3;
	}
	
	public void insertElement(Process processElement) {
		QueueNode head = firstNode;
		while(head.next != firstNode) {
			if(head.next.processElement.name != null && head.processElement.name == null) {
				head.processElement.name = processElement.name;
				head.processElement.cpuTime = processElement.cpuTime;
				head.processElement.pid = processElement.pid;
				return;
			}
			head = head.next;
		}
		if(head.next == firstNode && head.processElement.name == null) {
			head.processElement.name = processElement.name;
			head.processElement.cpuTime = processElement.cpuTime;
			head.processElement.pid = processElement.pid;
		}

	}
	
	public void deleteElement() {
		
	}
	
	public void displayElements() {
		QueueNode dummy = firstNode;
		while(dummy.processElement != null) {
			System.out.println(dummy.processElement.name);
			System.out.println(dummy.processElement.pid);
			System.out.println(dummy.processElement.cpuTime);
			System.out.println("\n");
			if(dummy.next == firstNode) {
				break;
			}
			dummy = dummy.next;
		}
	}

	public static void main(String[] args) {
		CircularLinkedQueue clq = new CircularLinkedQueue();
		Process processOne = new Process("processOne", 123, 198567);
		Process processTwo = new Process("processTwo", 890, 206567);
		Process processThree = new Process("processThree", 890, 206567);
		Process processFour = new Process("processFour", 890, 206567);
		clq.insertElement(processOne);
		clq.insertElement(processTwo);
		clq.insertElement(processThree);
		clq.insertElement(processFour);
		clq.displayElements();

	}

}
