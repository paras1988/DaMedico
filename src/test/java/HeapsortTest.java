import com.Heap.Heapsort;
import org.junit.Test;

public class HeapsortTest {

	@Test
	public void test(){
		int[] arr={6,1,34,56,2,5,8,1,3,6,3,5,0,05,45};
		Heapsort.sortMax(arr);

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

		System.out.println("\nMIn");

		Heapsort.sortMin(arr);

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}