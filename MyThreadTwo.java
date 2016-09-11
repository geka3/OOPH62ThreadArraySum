
public class MyThreadTwo extends Thread {

	int[] array = null;
	int from = 0;
	int to = 0;
	int result = 0;

	public MyThreadTwo(int[] array, int from, int to) {
		super();
		this.array = array;
		this.from = from;
		this.to = to;

	}

	public MyThreadTwo() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = from; i < to; i++) {
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
