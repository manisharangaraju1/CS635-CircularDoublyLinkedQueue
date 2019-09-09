
public class Process {
	
	String name;
	int cpuTime;
	int pid;
	
	public Process() {
		
	}
	
	public Process(String name, int pid, int cpuTime) {
		this.name = name;
		this.cpuTime = cpuTime;
		this.pid = pid;
	}
}
