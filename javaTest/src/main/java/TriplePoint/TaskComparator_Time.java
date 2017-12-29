package TriplePoint;

import java.util.Comparator;

public class TaskComparator_Time extends TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		return o2.getTimeTaken().compareTo(o1.getTimeTaken());
	}

}
