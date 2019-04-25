package marko.day1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Frequency2 {

	public static void main(String[] args) {
		Path path = Paths.get("day1_captcha.txt");
		int frequency = 0;
		List<Integer> lista= new ArrayList<>();
		Set<Integer> set = new LinkedHashSet<>();
		
		try(Scanner sc = new Scanner(path)){
			
			while(sc.hasNextLine()) {
				frequency += Integer.parseInt(sc.nextLine());
				
				if(!set.add(frequency)) {
					System.out.println(frequency);
					break;
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(frequency);
		System.out.println(set);

	}

}
