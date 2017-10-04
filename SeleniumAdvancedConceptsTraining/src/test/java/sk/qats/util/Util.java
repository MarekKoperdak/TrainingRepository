package sk.qats.util;

import java.util.Random;

public class Util {
	public static void randomSleep() throws InterruptedException {
		Random rand = new Random();
		int i = rand.nextInt(6000) + 2000;
		Thread.sleep(i);
	}

}
