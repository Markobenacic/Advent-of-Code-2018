package marko.day1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Frequency {

	public static void main(String[] args) {
		Path path = Paths.get("day1_captcha.txt");
		int frequency = 0;
		
		try(Scanner sc = new Scanner(path)){
			
			while(sc.hasNextLine()) {
				frequency += Integer.parseInt(sc.nextLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(frequency);

	}

}
