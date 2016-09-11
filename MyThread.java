import java.math.BigInteger;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyThread implements Runnable{
	int [] array = null;
	int from = 0;
	int to = 0;
	int result;
	
	public MyThread() {
		super();
	}

	public MyThread(int[] array, int from, int to) {
		super();
		this.array = array;
		this.from = from;
		this.to = to;
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = from; i < to; i++){
			sum += array[i];
			
		}
		result = sum;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	
	
	
}
