
import java.util.ArrayList;

class QueueNode {
    Process processElement;
    QueueNode next;
    QueueNode prev;

    public QueueNode() {
        this.processElement = new Process();
    }
}

public class CircularLinkedQueue {
    int capacity;
    int nodeIndex;
    QueueNode firstNode;
    QueueNode secondNode;
    QueueNode lastNode;
    QueueNode frontNode;
    QueueNode rearNode;

    public CircularLinkedQueue() {
        firstNode = new QueueNode();
        secondNode = new QueueNode();
        lastNode = new QueueNode();
        firstNode.next = secondNode;
        secondNode.next = lastNode;
        lastNode.next = firstNode;
        firstNode.prev = lastNode;
        secondNode.prev = firstNode;
        lastNode.prev = secondNode;
        frontNode = firstNode;
        rearNode = firstNode;
        capacity = 3;
        nodeIndex = 0;
    }


    public void insertElement(Process processElement) {
        if (frontNode == rearNode && frontNode.processElement.getName() != null) {
            resize();
        }
        if (rearNode.processElement.getName() == null) {
            rearNode.processElement.setName(processElement.getName());
            rearNode.processElement.setOwner(processElement.getOwner());
            rearNode.processElement.setCpuTime(processElement.getCpuTime());
            rearNode.processElement.setPid(processElement.getPid());
            rearNode.processElement.setNumberOfThreads(processElement.getNumberOfThreads());

            rearNode = rearNode.next;
        }
    }


    public void resize() {
        for (int nodeIncreaseCount = 0; nodeIncreaseCount < capacity; nodeIncreaseCount++) {
            QueueNode newElement = new QueueNode();
            newElement.next = rearNode;
            newElement.prev = rearNode.prev;
            rearNode.prev.next = newElement;
            rearNode.prev = newElement;
            rearNode = rearNode.prev;
        }
        capacity *= 2;
    }


    public void deleteElement() {
        frontNode.processElement = new Process();
        frontNode = frontNode.next;
    }

    public void displayElements(String sortByAttribute) {

        ArrayList<Process> processList = new ArrayList<>();
        QueueNode dummy = frontNode;
        while (dummy.next != frontNode) {
            if (dummy.processElement.name != null) {
                processList.add(dummy.processElement);
            }
            dummy = dummy.next;
        }
        if (dummy.processElement.name != null)
            processList.add(dummy.processElement);
        Process[] processes = new Process[processList.size()];
        for (int index = 0; index < processes.length; index++) {
            processes[index] = processList.get(index);
        }
        new SortByOrder("pid").sort(processes, 0, processes.length - 1);

        for (Process process : processes) {
            System.out.println(process.getName());
            System.out.println(process.getOwner());
            System.out.println(process.getPid());
            System.out.println(process.getCpuTime());
            System.out.println(process.getNumberOfThreads());
        }
    }

    public void displayElementsTest() {

        QueueNode dummy = frontNode;
        while (dummy.next != frontNode) {

            System.out.println(dummy.processElement.name);
            System.out.println(dummy.processElement.pid);
            System.out.println(dummy.processElement.cpuTime);
            System.out.println("\n");
            dummy = dummy.next;
        }
        System.out.println(dummy.processElement.name);
        System.out.println(dummy.processElement.pid);
        System.out.println(dummy.processElement.cpuTime);

        System.out.println("FRONT NODE :" + frontNode.processElement.name);
    }


    public static void main(String[] args) {
        CircularLinkedQueue clq = new CircularLinkedQueue();
        Process processOne = new Process("processOne", "manisha", 100, 9, 10);
        Process processTwo = new Process("processTwo", "mani", 200, 8, 12);
        Process processThree = new Process("processThree", "Zee", 300, 7, 14);
        Process processFour = new Process("processFour", "Nishu", 400, 6, 16);
        Process processFive = new Process("processFive", "Manzee", 590, 5, 18);
        clq.insertElement(processOne);
        clq.insertElement(processTwo);
        clq.insertElement(processThree);
        clq.insertElement(processFour);

//        clq.insertElement(processFive);
        clq.deleteElement();
        clq.insertElement(processFive);
        clq.displayElements("pid");
        clq.insertElement(processOne);
//        clq.displayElements("pid");
//        clq.displayElementsTest();
//        clq.insertElement(processOne);
//        clq.displayElementsTest();
//        System.out.println(clq.getSize());
    }

}
