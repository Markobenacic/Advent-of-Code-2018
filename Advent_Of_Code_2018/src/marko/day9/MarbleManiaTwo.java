package marko.day9;

import java.util.LinkedList;
import java.util.List;

public class MarbleManiaTwo {

	public static void main(String[] args) {
		final int numberOfplayers = 418;
		long[] scores = new long[418];
		final long lastMarble = 71339*100;
		ListImplement marbles = new ListImplement();
		
		
		marbles.add(0);
		
		int currentMarble = 1;
		int currentPlayer = 0;
		
		while(currentMarble <= lastMarble) {
			if(currentMarble % 23 == 0) {
				scores[currentPlayer] += currentMarble;
				scores[currentPlayer] += marbles.remove();
			}else {
				marbles.add(currentMarble);
			}
			currentMarble++;
			if(currentPlayer == numberOfplayers - 1) {
				currentPlayer = 0;
			}else {
				currentPlayer++;
			}
			System.out.println(currentMarble);
		}
		
		long highScore = 0;
		int elf = 0;
		for(int i = 0, n = scores.length; i < n; i++) {
			if(scores[i] > highScore) {
				highScore = scores[i];
				elf = i;
			}
		}
		System.out.println("high score is " + highScore);
		System.out.println("elf " + elf);
	}

}
