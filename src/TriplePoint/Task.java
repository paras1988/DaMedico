package TriplePoint;

public class Task implements Comparable<Task>{

	private String taskName;
	private Float serviceFees;
	private Integer timeTaken;
	
	public Task(String taskName,Float serviceFees,Integer timeTaken) {
		this.taskName=taskName;
		this.serviceFees=serviceFees;
		this.timeTaken=timeTaken;
	}
	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Float getServiceFees() {
		return serviceFees;
	}

	public void setServiceFees(Float serviceFees) {
		this.serviceFees = serviceFees;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}


	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
