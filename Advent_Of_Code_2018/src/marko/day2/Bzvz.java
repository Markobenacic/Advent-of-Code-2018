package marko.day2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Bzvz {

	public static void main(String[] args) {
		Path path = Paths.get("lol.txt");
		int i = 0;
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNext()) {
				sc.nextLine();
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(i);
	}

}
