
public class Process {

    private String name;
    private String owner;
    private int pid;
    private int threadCount;
    private int cpuTimeUsed;
    private int totalCPUTime;
    private int PercentCPUTimeUsed;

    public Process() {

    }

    public Process(String name, String owner, int pid, int threadCount, int cpuTimeUsed, int totalCPUTime) {
        this.name = name;
        this.owner = owner;
        this.pid = pid;
        this.threadCount = threadCount;
        this.cpuTimeUsed = cpuTimeUsed;
        this.totalCPUTime = totalCPUTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) { this.pid = pid; }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getCpuTimeUsed() {
        return cpuTimeUsed;
    }

    public void setCpuTimeUsed(int cpuTimeUsed) {
        this.cpuTimeUsed = cpuTimeUsed;
    }

    public int getTotalCPUTime() {
        return totalCPUTime;
    }

    public void setTotalCPUTime(int totalCPUTime) {
        this.totalCPUTime = totalCPUTime;
    }

    public int getPercentCPUTimeUsed() { return (cpuTimeUsed/totalCPUTime) * 100; }
}
