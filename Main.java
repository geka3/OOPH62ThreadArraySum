import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating array
		Random rnd = new Random();
		long start;
		long end;
		int[] array = new int[350000000];

		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(100);
		}
		int sum = 0;
		start = System.currentTimeMillis();
		for (int i : array) {
			sum += i;
		}
		end = System.currentTimeMillis();
		int processors = Runtime.getRuntime().availableProcessors();

		System.out.println("sum of array for single thread is " + sum + " spend time is " + (end - start));

		// for multi
		start = System.currentTimeMillis();
		sum = getSumArray(array, 8);
		end = System.currentTimeMillis();
		System.out.println("sum of array for multi thread is " + sum + " spend time is " + (end - start));

		// for multi Two
		start = System.currentTimeMillis();
		sum = getSumArrayTwo(array, 8);
		end = System.currentTimeMillis();
		System.out.println("sum of array for multi Two thread is " + sum + " spend time is " + (end - start));

	}

	static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static int getSumArray(int[] array, int processors) {
		Thread[] Th = new Thread[processors];
		int result = 0;
		int partSize = array.length / processors;

		MyThread[] myTh = new MyThread[processors];
		for (int i = 0; i < processors; i++) {
			myTh[i] = new MyThread(array, partSize * i, min(partSize * (i + 1), array.length));

			Th[i] = new Thread(myTh[i]);
			Th[i].start();

		}

		for (int i = 0; i < processors; i++) {
			try {
				Th[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result += myTh[i].getResult();

		}
		

		return result;
	}

	public static int getSumArrayTwo(int[] array, int processors) {
		MyThreadTwo[] Th = new MyThreadTwo[processors];
		int result = 0;
		int partSize = array.length / processors;

		for (int i = 0; i < processors; i++) {
			Th[i] = new MyThreadTwo(array, partSize * i, min(partSize * (i + 1), array.length));

			Th[i].start();

		}

		for (int i = 0; i < processors; i++) {
			try {
				Th[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result += Th[i].getResult();

		}
		

		return result;
	}

}
