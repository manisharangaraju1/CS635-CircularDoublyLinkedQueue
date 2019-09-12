import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedQueueTest {

    //Testing the insertion operation into a queue
    @Test
    public void testInsertElement() throws Exception {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        Process processOne = new Process("processOne", "processOneOwner", 100, 9, 10, 20);
        circularLinkedQueue.insertQueueNode(processOne);
        assertEquals(circularLinkedQueue.frontNode.process.getName(), processOne.getName());
    }


    //Testing the resizing operation which doubles the capacity of queue when it is full.
    @Test
    public void testCapacityOfQueue() throws Exception {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        Process processOne = new Process("processOne", "processOneOwner", 100, 9, 10, 20);
        circularLinkedQueue.insertQueueNode(processOne);
        circularLinkedQueue.insertQueueNode(processOne);
        circularLinkedQueue.insertQueueNode(processOne);
        assertEquals(circularLinkedQueue.capacity, 4);
    }


    //Testing the deletion operation of a queue
    @Test
    public void testdeleteElement() throws Exception {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        Process processOne = new Process("processOne", "processOneOwner", 100, 9, 10, 20);
        circularLinkedQueue.insertQueueNode(processOne);
        circularLinkedQueue.deleteElement();
        assertEquals(circularLinkedQueue.frontNode.process.getName(), null);
    }


    //Testing ordering of queueNodes ordered by pid
    @Test
    public void displayQueueNodesOrderedByPid() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 20, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByPid = circularLinkedQueue.displayElements("pid");
        assertEquals(processOrderedByPid[0].getPid(), 102);
    }


    //Testing ordering of queueNodes ordered by Cpu Time used
    @Test
    public void displayQueueNodesOrderedByCpuTimeUsed() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("cpuTimeUsed");
        assertEquals(processOrderedByCpuTimeUsed[0].getCpuTimeUsed(), 20);
    }


    //Testing ordering of queueNodes ordered by Name
    @Test
    public void displayQueueNodesOrderedByName() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("name");
        assertEquals(processOrderedByCpuTimeUsed[0].getName(), "processFive");
    }


    //Testing ordering of queueNodes ordered by Owner
    @Test
    public void displayQueueNodesOrderedByOwner() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("owner");
        assertEquals(processOrderedByCpuTimeUsed[0].getOwner(), "processFiveOwner");
    }


    //Testing ordering of queueNodes ordered by Number of Threads
    @Test
    public void displayQueueNodesOrderedByThreadCount() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("threadCount");
        assertEquals(processOrderedByCpuTimeUsed[0].getThreadCount(), 139);
    }


    //Testing ordering of queueNodes ordered by Total Cpu Time
    @Test
    public void displayQueueNodesOrderedByTotalCpuTime() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 1200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 2400));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 2200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("totalCPUTime");
        assertEquals(processOrderedByCpuTimeUsed[0].getTotalCPUTime(), 200);
    }


    //Testing ordering of queueNodes ordered by percentage of the cpu time used
    @Test
    public void displayQueueNodesOrderedByPercentCpuTime() {
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue();
        circularLinkedQueue.insertQueueNode(new Process("processOne", "processOneOwner", 112, 139, 90, 200));
        circularLinkedQueue.insertQueueNode(new Process("processTwo", "processTwoOwner", 121, 326, 40, 1200));
        circularLinkedQueue.insertQueueNode(new Process("processThree", "processThreeOwner", 102, 533, 220, 2400));
        circularLinkedQueue.insertQueueNode(new Process("processFour", "processFourOwner", 117, 289, 190, 2200));
        circularLinkedQueue.insertQueueNode(new Process("processFive", "processFiveOwner", 190, 399, 290, 800));
        circularLinkedQueue.insertQueueNode(new Process("processSix", "processSixOwner", 202, 324, 20, 500));

        Process[] processOrderedByCpuTimeUsed = circularLinkedQueue.displayElements("percentCpuTimeUsed");
        assertEquals(processOrderedByCpuTimeUsed[0].getName(), "processSix");
    }


}