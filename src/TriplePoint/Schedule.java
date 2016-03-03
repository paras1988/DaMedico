package TriplePoint;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements Runnable{

	private Employee employee;
	private List<Task> tasks=new ArrayList<Task>();
	
	public Schedule(Employee employee,List<Task> tasks) {
		this.employee=employee;
		this.tasks.addAll(tasks);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void run() {
		
		for(Task t:tasks){
			System.out.println("Running task "+t.getTaskName() +" for User "+ employee.getName()+" task time "+t.getTimeTaken()+ " service Fees "+t.getServiceFees());
		}
	}
	
	
}
