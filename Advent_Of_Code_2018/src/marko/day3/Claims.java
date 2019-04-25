package marko.day3;

import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Claims {

	public static void main(String[] args) {
		Path path = Paths.get("day3_captcha.txt");
		List<String> list = new ArrayList<>();
		List<Claim> claimovi = new ArrayList<Claim>();
		
		int[][] fabric = new int[1000][1000];
		
		
		int overlaps = 0;
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				
				list.add(s);
				
				String[] at = s.split("@");
				at[0] = at[0].substring(1).trim();	// tu je id
				at[1] = at[1].trim();
				
				String[] dvotocka = at[1].split(":");
				String[] zarez = dvotocka[0].trim().split(","); // u zarezu su leftEdge, topEdge
				
				String[] iks = dvotocka[1].trim().split("x"); // tu su width i height
				
				claimovi.add(new Claim(Integer.parseInt(at[0]), Integer.parseInt(zarez[0])
						, Integer.parseInt(zarez[1]), Integer.parseInt(iks[0]), Integer.parseInt(iks[1])));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//odredio sam da mi 0 znači ništa claimova, int 1 znači jedan claim, a int 2 znači dva ili više
		
		for(Claim c : claimovi) {
			for(int i = c.topEdge; i < c.topEdge + c.height ; i++) {
				for(int j = c.leftEdge; j < c.leftEdge + c.width ; j++) {
					if(fabric[i][j] == 0) {
						fabric[i][j]++;
					}else if (fabric[i][j] == 1) {
						fabric[i][j]++;
					}
				}
			}
		}
		for(int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j ++){
				if (fabric[i][j] == 2) {
					overlaps++;
				}
			}
		}
		System.out.println("overlaps: " + overlaps);

		
		
		int idLonera = 0;
		
		for(Claim c : claimovi) {
			boolean loner = true;
			for(int i = c.topEdge; i < c.topEdge + c.height ; i++) {
				for(int j = c.leftEdge; j < c.leftEdge + c.width ; j++) {
					if(fabric[i][j] != 1) {
						loner = false;
					}
				}
			}
			if(loner) {
				idLonera = c.id;
				break;
			}
		}
		
		System.out.println("loner je: " + idLonera);
		
	}
	
}
