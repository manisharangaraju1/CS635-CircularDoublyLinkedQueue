import java.util.ArrayList;
import java.util.Comparator;

public class SortByOrder {
    Process[] processList;
    QueueNode frontNodeReference;

    public SortByOrder(QueueNode frontNode) {
        this.frontNodeReference = frontNode;
    }

    public int getNodeCount() {
        int nodeCount = 0;
        QueueNode traverseNode = frontNodeReference;
        if (traverseNode.process.getName() != null) {
            nodeCount++;
            traverseNode = traverseNode.next;
        }
        while (traverseNode != frontNodeReference && traverseNode.process.getName() != null) {
            nodeCount++;
            traverseNode = traverseNode.next;
        }
        return nodeCount;
    }

    public void createProcessList() {
        processList = new Process[getNodeCount()];
        ArrayList<Process> processes = new ArrayList<>();
        QueueNode dummy = frontNodeReference;
        while (dummy.next != frontNodeReference) {
            if (dummy.process.getName() != null) {
                processes.add(dummy.process);
            }
            dummy = dummy.next;
        }
        if (dummy.process.getName() != null)
            processes.add(dummy.process);

        for (int indexOfProcessList = 0; indexOfProcessList < processList.length; indexOfProcessList++) {
            processList[indexOfProcessList] = processes.get(indexOfProcessList);
        }
    }

    public Process[] sortByAttribute(String sortByAttribute) {
        createProcessList();
        //Create an array with all the processes and call the sort function with the attribute that it is sorted by
        switch (sortByAttribute) {
            case "pid":
                sort(processList, 0, processList.length - 1, new CompareByPid());
                break;
            case "name":
                sort(processList, 0, processList.length - 1, new CompareByName());
                break;
            case "owner":
                sort(processList, 0, processList.length - 1, new CompareByOwner());
                break;
            case "threadCount":
                sort(processList, 0, processList.length - 1, new CompareByThreadCount());
                break;
            case "cpuTimeUsed":
                sort(processList, 0, processList.length - 1, new CompareByCPUTimeUsed());
                break;
            case "totalCPUTime":
                sort(processList, 0, processList.length - 1, new CompareByTotalCPUTime());
                break;
            case "percentCpuTimeUsed":
                sort(processList, 0, processList.length - 1, new CompareByPercentCPUTimeUsed());
                break;
        }
        return processList;
    }

    private void sort(Process[] processesToSort, int startIndex, int endIndex, Comparator comparatorInstance) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;

            //Sort first half of array
            sort(processesToSort, startIndex, middleIndex, comparatorInstance);

            //Sort Second Half of array
            sort(processesToSort, middleIndex + 1, endIndex, comparatorInstance);

            //merge the sorted sub arrays
            merge(processesToSort, startIndex, middleIndex, endIndex, comparatorInstance);
        }
    }

    private void merge(Process[] processesToSort, int startIndex, int middleIndex, int endIndex, Comparator comparatorInstance) {

        // Find sizes of both subarrays
        int leftSubArrayLength = middleIndex - startIndex + 1;
        int rightSubArrayLength = endIndex - middleIndex;

        // Create separate arrays for both sub arrays
        Process[] leftSubArray = new Process[leftSubArrayLength];
        Process[] rightSubArray = new Process[rightSubArrayLength];

        // Copy data to sub arrays
        for (int index = 0; index < leftSubArrayLength; ++index)
            leftSubArray[index] = processesToSort[startIndex + index];
        for (int index = 0; index < rightSubArrayLength; ++index)
            rightSubArray[index] = processesToSort[middleIndex + 1 + index];

        // Indexes to keep track of both the sub arrays
        int indexOfLeftSubArray = 0;
        int indexOfRightSubArray = 0;

        // Initial index of merged subarry array
        int indexOfProcessesArray = startIndex;
        while (indexOfLeftSubArray < leftSubArrayLength && indexOfRightSubArray < rightSubArrayLength) {
            if (comparatorInstance.compare(leftSubArray[indexOfLeftSubArray], rightSubArray[indexOfRightSubArray]) < 0) {
                processesToSort[indexOfProcessesArray] = leftSubArray[indexOfLeftSubArray];
                indexOfLeftSubArray++;
            } else {
                processesToSort[indexOfProcessesArray] = rightSubArray[indexOfRightSubArray];
                indexOfRightSubArray++;
            }
            indexOfProcessesArray++;
        }

        // Copy remaining elements of Left sub array if any
        while (indexOfLeftSubArray < leftSubArrayLength) {
            processesToSort[indexOfProcessesArray] = leftSubArray[indexOfLeftSubArray];
            indexOfLeftSubArray++;
            indexOfProcessesArray++;
        }

        // Copy remaining elements of right sub array if any
        while (indexOfRightSubArray < rightSubArrayLength) {
            processesToSort[indexOfProcessesArray] = rightSubArray[indexOfRightSubArray];
            indexOfRightSubArray++;
            indexOfProcessesArray++;
        }
    }

    public static class CompareByPid implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getPid() - processTwo.getPid();

        }
    }

    public static class CompareByName implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getName().compareTo(processTwo.getName());

        }
    }

    public static class CompareByOwner implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getOwner().compareTo(processTwo.getOwner());

        }
    }

    public static class CompareByThreadCount implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getThreadCount() - processTwo.getThreadCount();

        }
    }

    public static class CompareByCPUTimeUsed implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getCpuTimeUsed() - processTwo.getCpuTimeUsed();

        }
    }

    public static class CompareByTotalCPUTime implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getTotalCPUTime() - processTwo.getTotalCPUTime();

        }
    }

    public static class CompareByPercentCPUTimeUsed implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getPercentCPUTimeUsed() - processTwo.getPercentCPUTimeUsed();
        }
    }

}
