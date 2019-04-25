package marko.day1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Frequency2a {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Path path = Paths.get("day1_captcha.txt");
		int frequency = 0;
		List<Integer> lista= new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {		// <---  punjenje liste promjena frekvencija
				lista.add(Integer.parseInt(sc.nextLine()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		outerloop:			
		while(true) {	
			for(Integer i : lista) {
				if(!set.add(frequency)) {
					break outerloop;
				}
				frequency += i;
				
			}
		}
		System.out.println(frequency);
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("vrijeme izvrsavanja: " + elapsedTime + "ms");
	}
	
}
