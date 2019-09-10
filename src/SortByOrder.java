import java.util.Comparator;

public class SortByOrder {
    private String sortByAttribute;
    private Comparator instance;

    public SortByOrder(String sortByAttribute) {
        this.sortByAttribute = sortByAttribute;
        switch (sortByAttribute) {
            case "pid":
                instance = new CompareByPid();
            case "name":
                instance = new CompareByName();
            case "owner":
                instance = new CompareByOwner();
            case "threadCount":
                instance = new CompareByThreadCount();
            case "CPUTime":
                instance = new CompareByCPUTime();
        }
    }


    public void sort(Process[] processesToSort, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;

            //Sort first half
            sort(processesToSort, startIndex, middleIndex);

            //Sort Second Half
            sort(processesToSort, middleIndex + 1, endIndex);

            //merge the sorted sub arrays
            merge(processesToSort, startIndex, middleIndex, endIndex);
        }
    }

    private void merge(Process[] processesToSort, int startIndex, int middleIndex, int endIndex) {

        //Find sizes of both subarrays
        int leftSubArrayLength = middleIndex - startIndex + 1;
        int rightSubArrayLength = endIndex - middleIndex;

        /* Create separate arrays for both sub arrays*/
        Process[] leftSubArray = new Process[leftSubArrayLength];
        Process[] rightSubArray = new Process[rightSubArrayLength];

        /*Copy data to sub arrays*/
        for (int index = 0; index < leftSubArrayLength; ++index)
            leftSubArray[index] = processesToSort[startIndex + index];
        for (int index = 0; index < rightSubArrayLength; ++index)
            rightSubArray[index] = processesToSort[middleIndex + 1 + index];

        //Indexes to keep track of both the sub arrays
        int indexOfLeftSubArray = 0;
        int indexOfRightSubArray = 0;

        // Initial index of merged subarry array
        int indexOfProcessesArray = startIndex;
        while (indexOfLeftSubArray < leftSubArrayLength && indexOfRightSubArray < rightSubArrayLength) {

            if (instance.compare(leftSubArray[indexOfLeftSubArray], rightSubArray[indexOfRightSubArray]) < 0) {
                processesToSort[indexOfProcessesArray] = leftSubArray[indexOfLeftSubArray];
                indexOfLeftSubArray++;
            } else {
                processesToSort[indexOfProcessesArray] = rightSubArray[indexOfRightSubArray];
                indexOfRightSubArray++;
            }
            indexOfProcessesArray++;
        }

        /* Copy remaining elements of Left sub array if any */
        while (indexOfLeftSubArray < leftSubArrayLength) {
            processesToSort[indexOfProcessesArray] = leftSubArray[indexOfLeftSubArray];
            indexOfLeftSubArray++;
            indexOfProcessesArray++;
        }

        /* Copy remaining elements of right sub array if any */
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
            return processOne.getNumberOfThreads() - processTwo.getNumberOfThreads();

        }
    }

    public static class CompareByCPUTime implements Comparator<Process> {
        @Override
        public int compare(Process processOne, Process processTwo) {
            return processOne.getCpuTime() - processTwo.getCpuTime();

        }
    }
}
