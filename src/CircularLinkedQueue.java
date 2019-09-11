class QueueNode {
    Process process;
    QueueNode next;
    QueueNode prev;

    public QueueNode() {
        this.process = new Process();
    }
}

public class CircularLinkedQueue {
    int capacity;

    //Initial two nodes
    QueueNode firstNode;
    QueueNode lastNode;

    QueueNode frontNode; //frontNode always points to the front of the queue
    QueueNode rearNode;  //rearNode always points to the node where insertion takes place

    public CircularLinkedQueue() {
        //Initializing two nodes
        firstNode = new QueueNode();
        lastNode = new QueueNode();

        firstNode.next = lastNode;
        firstNode.prev = lastNode;
        lastNode.prev = firstNode;
        lastNode.next = firstNode;

        frontNode = firstNode;
        rearNode = firstNode;
        capacity = 2; //initial capacity
    }


    public void insertQueueNode(Process processToBeInserted) {
        //Checking if all nodes are full, if yes then double the capacity of the Queue and insert the Node
        if (frontNode == rearNode && frontNode.process.getName() != null) {
            resize();
        }
        if (rearNode.process.getName() == null) {
            rearNode.process.setName(processToBeInserted.getName());
            rearNode.process.setOwner(processToBeInserted.getOwner());
            rearNode.process.setCpuTimeUsed(processToBeInserted.getCpuTimeUsed());
            rearNode.process.setPid(processToBeInserted.getPid());
            rearNode.process.setThreadCount(processToBeInserted.getThreadCount());
            rearNode.process.setTotalCPUTime(processToBeInserted.getTotalCPUTime());
            rearNode = rearNode.next;
        }
    }


    public void resize() {
        for (int nodeIncreaseCount = 0; nodeIncreaseCount < capacity; nodeIncreaseCount++) {
            QueueNode newQueueNode = new QueueNode();
            newQueueNode.next = rearNode;
            newQueueNode.prev = rearNode.prev;
            rearNode.prev.next = newQueueNode;
            rearNode.prev = newQueueNode;
            rearNode = rearNode.prev;
        }
        capacity *= 2;
    }


    public void deleteElement() {
        frontNode.process = new Process();
        frontNode = frontNode.next;
    }


    public Process[] displayElements(String sortByAttribute) {
        SortByOrder sortByOrder = new SortByOrder(frontNode);
        return sortByOrder.sortByAttribute(sortByAttribute);
    }
}
