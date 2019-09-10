
public class Process {
	
	String name;
	String owner;
	int pid;
	int numberOfThreads;
	int cpuTime;

	public Process() {
		
	}

	public Process(String name, String owner, int pid, int numberOfThreads, int cpuTime) {
		this.name = name;
		this.owner = owner;
		this.pid = pid;
		this.numberOfThreads = numberOfThreads;
		this.cpuTime = cpuTime;
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

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}
}
