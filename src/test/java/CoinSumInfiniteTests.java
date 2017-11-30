import java.util.ArrayList;

import com.GeekFGeeks.DP.CoinSumInfinite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinSumInfiniteTests {

	private CoinSumInfinite coinSumInfinite;

	@Before
	public void setup(){
		this.coinSumInfinite=new CoinSumInfinite();
	}

	@Test
	public void whenGeneralCaseThenExpectedResult(){
		ArrayList<Integer> input=new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		int res=coinSumInfinite.coinchange(input, 4);
		Assert.assertEquals(4,res);
	}

	@Test
	public void whenChangeNeededisZeroThenExpectedisOne(){
		ArrayList<Integer> input=new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		int res=coinSumInfinite.coinchange(input, 0);
		Assert.assertEquals(1,res);
	}
}