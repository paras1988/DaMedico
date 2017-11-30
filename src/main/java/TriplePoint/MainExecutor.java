package TriplePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
	public static void main(String[] args) throws InterruptedException {

		final Employee e1=new Employee("Joe","Trainee");
		final Employee e2=new Employee("Smith","Expert");
		final Employee e3=new Employee("Walker","Employee");

		final Task t1=new Task("Car-Wash", (float) 100, 2);
		final Task t2=new Task("Car-Repair", (float) 1000, 5);
		final Task t3=new Task("Car-Paint", (float) 1100, 4);

		final List<Task> tasks_e1=new ArrayList<Task>();
		tasks_e1.add(t1);
		tasks_e1.add(t2);
		tasks_e1.add(t3);

		final List<Task> tasks_e2=new ArrayList<Task>();
		tasks_e2.add(t2);

		final List<Task> tasks_e3=new ArrayList<Task>();
		tasks_e3.add(t2);
		tasks_e3.add(t3);

		TaskComparator timeComparator=ComparatorFactory.getComparator(TaskCategory.TIME);
		Collections.sort(tasks_e1,timeComparator);
		Collections.sort(tasks_e2,timeComparator);
		Collections.sort(tasks_e3,timeComparator);

		final Schedule s1_time=new Schedule(e1,tasks_e1);
		final Schedule s2_time=new Schedule(e2,tasks_e2);
		final Schedule s3_time=new Schedule(e3,tasks_e3);

		TaskComparator serviceFeesComparator=ComparatorFactory.getComparator(TaskCategory.SERVICE_FEES);
		Collections.sort(tasks_e1,serviceFeesComparator);
		Collections.sort(tasks_e2,serviceFeesComparator);
		Collections.sort(tasks_e3,serviceFeesComparator);


		final Schedule s1_fees=new Schedule(e1,tasks_e1);
		final Schedule s2_fees=new Schedule(e2,tasks_e2);
		final Schedule s3_fees=new Schedule(e3,tasks_e3);

		final ExecutorService es1 = Executors.newFixedThreadPool(3);
		es1.execute(s1_time);
		es1.execute(s2_time);
		es1.execute(s3_time);

		Thread.sleep(100);
		System.out.println("---------------------------");

		final ExecutorService es2 = Executors.newFixedThreadPool(3);
		es2.execute(s1_fees);
		es2.execute(s2_fees);
		es2.execute(s3_fees);

		es1.shutdown();
		es2.shutdown();
	}
}
