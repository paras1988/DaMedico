package TriplePoint;

public class ComparatorFactory {

	public static TaskComparator getComparator(TaskCategory taskCategory){
		switch(taskCategory){
		 
		case TIME:
			return new TaskComparator_Time();
		case SERVICE_FEES:
			return new TaskComparator_Fees();
		default:
			System.out.println("Invalid entry");
			return null;
		}
	}
	
	
}
