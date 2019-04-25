package marko.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MarbleMania {

	public static void main(String[] args) {
		final int numberOfplayers = 418;
		int[] scores = new int[418];
		final int lastMarble = 71339;
		List<Integer> marbles = new LinkedList<>();
		int marblesSize = 0;
		
		
		marbles.add(0);
		marblesSize++;
		int currentMarble = 1;
		
		int currentPlayer = 0;
		int pointer = 0;
		while(currentMarble <= lastMarble) {
			if(currentMarble % 23 == 0) {
				scores[currentPlayer] += currentMarble;
				
				for(int i = 0; i < 7; i++) {
					if(pointer == 0) {
						pointer = marblesSize - 1;
					}else {
						pointer--;
					}
				}
				scores[currentPlayer] += marbles.remove(pointer);
				marblesSize--;
				
			}
			else {
				for(int i = 0; i < 2; i++) {
					if(pointer == marblesSize - 1) {
						pointer = 0;
					}else {
						pointer++;
					}
				}
				marbles.add(pointer, currentMarble);
				marblesSize++;
			}
			currentMarble++;
			if(currentPlayer == numberOfplayers - 1) {
				currentPlayer = 0;
			}else {
				currentPlayer++;
			}
			System.out.println("current marble: " + currentMarble);
		}
		
		int highScore = 0;
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
