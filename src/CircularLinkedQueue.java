
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    QueueNode head; //Always points to first Node

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
        head = firstNode;
        capacity = 3;
        nodeIndex = 0;
    }


    public void insertElement(Process processElement) {
        if (getOccupiedNodesSize() == capacity) {
            resize();
        }
        QueueNode traverseNode = head;
        while (traverseNode.next != head) {
            if (traverseNode.next.processElement.name != null && traverseNode.processElement.name == null) {
                traverseNode.processElement.name = processElement.name;
                traverseNode.processElement.cpuTime = processElement.cpuTime;
                traverseNode.processElement.pid = processElement.pid;
                traverseNode.processElement.owner = processElement.owner;
                traverseNode.processElement.numberOfThreads = processElement.numberOfThreads;
//                System.out.println("FirstInsert : " + traverseNode.processElement.name);
                return;
            }
            traverseNode = traverseNode.next;
        }
        if (traverseNode.next == head && traverseNode.processElement.name == null) {
            traverseNode.processElement.name = processElement.name;
            traverseNode.processElement.cpuTime = processElement.cpuTime;
            traverseNode.processElement.pid = processElement.pid;
            traverseNode.processElement.owner = processElement.owner;
            traverseNode.processElement.numberOfThreads = processElement.numberOfThreads;
//            System.out.println("SecondInsert : " + traverseNode.processElement.name);
            return;
        }
    }


    public void resize() {
        for (int nodeIncreaseCount = 0; nodeIncreaseCount < capacity; nodeIncreaseCount++) {
            QueueNode newElement = new QueueNode();
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


    public void displayElements(String sortByAttribute) {
        ArrayList<Process> processList = new ArrayList<>();
        QueueNode dummy = head;
        while (dummy.next != head) {
            if (dummy.processElement.name != null) {
                processList.add(dummy.processElement);
            }
            dummy = dummy.next;
        }
        if (dummy.processElement.name != null)
            processList.add(dummy.processElement);


        switch (sortByAttribute) {
            case "pid":
                Collections.sort(processList, new Comparator<Process>() {
                    @Override
                    public int compare(Process processOne, Process processTwo) {
                        return processOne.getPid() - processTwo.getPid();
                    }
                });
            case "cpuTime":
                Collections.sort(processList, new Comparator<Process>() {
                    @Override
                    public int compare(Process processOne, Process processTwo) {
                        return processOne.getCpuTime() - processTwo.getCpuTime();
                    }
                });
            case "name":
                Collections.sort(processList, new Comparator<Process>() {
                    @Override
                    public int compare(Process processOne, Process processTwo) {
                        return processOne.getName().compareTo(processTwo.getName());
                    }
                });
            case "owner":
                Collections.sort(processList, new Comparator<Process>() {
                    @Override
                    public int compare(Process processOne, Process processTwo) {
                        return processOne.getOwner().compareTo(processTwo.getOwner());
                    }
                });
            case "threadCount":
                Collections.sort(processList, new Comparator<Process>() {
                    @Override
                    public int compare(Process processOne, Process processTwo) {
                        return processOne.getNumberOfThreads() - processTwo.getNumberOfThreads();
                    }
                });
        }

        for (Process process : processList) {
            System.out.println(process.getName());
            System.out.println(process.getOwner());
            System.out.println(process.getPid());
            System.out.println(process.getCpuTime());
            System.out.println(process.getNumberOfThreads());
        }
    }


    public int getOccupiedNodesSize() {
        int size = 0;
        QueueNode traveseNode = head;
        while (traveseNode.next != head) {
            if (traveseNode.processElement.name != null) {
                size++;
            }
            traveseNode = traveseNode.next;
        }
        if (head.prev.processElement.name == null) return size;
        return size + 1;
    }


    public void displayElementsTest() {
        QueueNode dummy = head;
        while (dummy.next != head) {

            System.out.println(dummy.processElement.name);
            System.out.println(dummy.processElement.pid);
            System.out.println(dummy.processElement.cpuTime);
            System.out.println("\n");
            dummy = dummy.next;
        }
        System.out.println(dummy.processElement.name);
        System.out.println(dummy.processElement.pid);
        System.out.println(dummy.processElement.cpuTime);

        System.out.println("HEAD :" + head.processElement.name);
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
        clq.insertElement(processFive);
        clq.displayElements("pid");
        clq.deleteElement();
//        clq.displayElementsTest();
//        System.out.println(clq.getSize());
    }

}
