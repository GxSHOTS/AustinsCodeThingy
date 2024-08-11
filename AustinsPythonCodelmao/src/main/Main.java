/**
 * 
 */
package main;

import java.util.Random;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	static long starttime;
	static long endtime;
	static long timetaken;
	
	static int numbers[] = {0,0,0,0};
	static int dice[] = {1,2,3,4}; // 1 is paralysis(good), 2-4 is not(fail)
	static long rolls = 0;
	static long maxones = 0;
	static Random rnd;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long seed = System.nanoTime();
		rnd = new Random(seed);
		try {
			starttime = System.nanoTime();
			
			while(numbers[0] < 177 && rolls < 1000000000) {
				
				numbers[0] = 0;
				numbers[1] = 0;
				numbers[2] = 0;
				numbers[3] = 0;
				for(int i = 0; i < 231; i++) {
					int roll = rnd.nextInt(0, 4); //shifted to fit the array, bound is exclusive so is 4
					numbers[roll]++;
				}
				rolls++;
				if(numbers[0] > maxones) maxones = numbers[0];
			}
			
			endtime = System.nanoTime();
			System.out.println("Highest: " + maxones);
			System.out.println("Time taken: " + ((endtime - starttime)) + "ns [" + ((endtime - starttime) / 1000000000) + "s]");
			System.out.println("Total Rolls: " + rolls);
			System.out.println("Random Seed: " + seed);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
