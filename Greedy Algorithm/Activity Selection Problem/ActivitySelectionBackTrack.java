package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ActivitySelectionBackTrack {

	private Activity[] currentResult;
	static  Activity[] finalResult;
	private static boolean[] marked;
	static int N;
	private int numActivity; 
	static int maxActivity;

	public ActivitySelectionBackTrack(Activity[] activities, int N) {

		this.numActivity = 0;
		this.maxActivity = 0;
		this.N = N;

		this.currentResult = new Activity[N+1];
		this.finalResult = new Activity[N+1];
		this.marked = new boolean[N];

		//		for(int action = 0; action < N; action++) {
		//
		for(int i = 0; i < currentResult.length; i++) {
			currentResult[i] = new Activity(-1, -1);
		}
		//			// ban dau chua su dung action nao
		//			Arrays.fill(marked, false);
		//
		//			// chon hanh dong dau tien vao cau hinh
		//			currentResult[0] = activities[action];
		//			// danh dau da chon hanh dong
		//			marked[action] = true;
		//		
		//			// tim cac kha nang cho hoat dong thu X[i+1]
		//			backTrack(activities, 1);
		//		}

		// ban dau chua su dung action nao
		Arrays.fill(marked, false);

		// chon hanh dong dau tien vao cau hinh
		currentResult[0] = activities[0];
		// danh dau da chon hanh dong
		marked[0] = true;

		backTrack(activities, 1);
	}

	public void backTrack(Activity[] activities, int level) {

		if(isConFig()) {
			System.out.println("(((Tim thay nghiem)))");
		}

		// tim ung vien xj  
		for(int j = 1; j < N; j++)		
		{
			// tinh min nhung thg con lai

			int min = findMinActivity(activities, level);
			System.out.println("Min" + min);
			System.out.println("Level hien tai" + activities[level-1].toString());
			// so sanh object
			if(activities[level-1].getFinish() + min < 16
					&& marked[j] == false && activities[j].getStart() > activities[level-1].getFinish())
			{
				// ghi nhan thanh phan xj
				
				marked[j] = true;
				currentResult[level] = activities[j];
				numActivity++;
				level = j;
				System.out.println("Level va j" + level + ", " + j);
				
				printSelection(currentResult);
				// de quy tim cac kha nang cho hoat dong thu X[i+1]
				backTrack(activities, level);

				marked[j] = false;
				// loai bo cau hinh thu i
				currentResult[level] = new Activity(-1, -1);
				numActivity--;
			}

		}
	}

	public static int findMinActivity(Activity[] activities, int level) {
		int min = Integer.MAX_VALUE;
		for(int i = level ; i < N; i++)
			if(marked[i] == false) 
			{
				System.out.println("CHUA LAP" + activities[i].toString());
				if(activities[i].getFinish() - activities[i].getStart() < min)
				{
					min = activities[i].getFinish() - activities[i].getStart();
				}
			}
		
		return min;
	}
	
	public boolean isConFig()
	{
		boolean isConFig = false;
		if(numActivity > maxActivity) {
			maxActivity = numActivity;
			updateResult(currentResult);
			isConFig = true;
		}
		return isConFig;
	}

	public void updateResult(Activity[] currentResult) {

		for(int i = 0; i < currentResult.length; i++) 
			finalResult[i] = currentResult[i];
		//		System.out.println("final = ");
		//		printSelection(finalResult);
	}

	public void printSelection(Activity[] currentResult)
	{
		System.out.println("Cau hinh hien tai");
		for(int i = 0; i < currentResult.length;i++) 
			System.out.print(currentResult[i] + " ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		//		int N;
		//		Scanner keyboard = new Scanner(System.in);
		//
		//		// nhap so hoat dong
		//		System.out.println("Input N = ");
		//		N = keyboard.nextInt();

		int N = 9;
		Activity[] activities = new Activity[N];
		//		int[] start = { 1, 2, 3, 4, 8, 7, 9, 11, 9, 12 };
		//	    int[] finish = { 3, 5, 4, 7, 9, 10, 11, 12, 13, 14 };
		activities[0] = new Activity(1, 3);
		activities[1] = new Activity(2, 5);
		activities[2] = new Activity(4, 7);
		activities[3] = new Activity(1, 8);
		activities[4] = new Activity(5, 9);
		activities[5] = new Activity(8, 10);
		activities[6] = new Activity(9, 11);
		activities[7] = new Activity(11, 14);
		activities[8] = new Activity(13, 16);
		//		activities[7] = new Activity(11, 12);
		//		activities[8] = new Activity(9, 13);
		//		activities[9] = new Activity(12, 14);



		// random cac hoat dong
		//		Random random = new Random();

		//		for (int i = 0; i < N; i++) {
		//			int start = ThreadLocalRandom.current().nextInt(1, 10);
		//			int finish = ThreadLocalRandom.current().nextInt(11, 100);
		//			activities[i] = new Activity(start, finish);
		//		}
		//keyboard.close();

		// hien thi cac hoat dong duoc random
		System.out.println("Activity = ");
		for (int i = 0; i < N; i++) {
			System.out.println(activities[i].toString());
		}


		ActivitySelectionBackTrack bestShedule = new ActivitySelectionBackTrack(activities, N);
		System.out.println("Best config = ");
		for(int i = 0; i < N; i++) {
			System.out.println(finalResult[i].toString());
		}

		System.out.println("So hoat dong = " + maxActivity);
	}
}
