package marko.day6;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ChronalCoordinates {

	public static void main(String[] args) {
		
		Path path = Paths.get("day6_captcha.txt");
		List<int[]> koordinate = new ArrayList<>();
		
		try(Scanner sc = new Scanner(path)){
			
			while(sc.hasNextLine()) {
				
				String[] s = sc.nextLine().split(",");
				int arr[] = new int[2];
				arr[0] = Integer.parseInt(s[0].trim());
				arr[1] = Integer.parseInt(s[1].trim());
				
				koordinate.add(arr);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		int[][] arr = new int[500][500];
		
		for(int i = 0; i < 500; i++) {
			for(int j = 0; j <500; j++) {
				arr[i][j] = najblizaKoordinata(i,j,arr,koordinate);
			}
		}
		
		//trazenje beskonacnih
		Set<Integer> beskonacni = new TreeSet<>();
		for(int j = 0; j < 500; j++) {
			beskonacni.add(arr[0][j]);
			beskonacni.add(arr[j][0]);
			beskonacni.add(arr[499][j]);
			beskonacni.add(arr[j][499]);
		}
		
		
		// prebrojavanje najveceg kvadranta
		int najveci = 0;
		int trenutni = 0;
		int indexNajveceg = 1;
		
		
		for(int n = 0; n < koordinate.size(); n++) {
			int size = 0;
			
			for(int i = 0; i < 500; i++) {
				for(int j = 0; j < 500; j++) {
					if(!beskonacni.contains(n+1)) {
						if(arr[i][j] != 0) {
							if(arr[i][j] == n + 1) {
								size++;
							}
						}
					}
				}
			}
			if (size > najveci) {
				najveci = size;
				indexNajveceg = n + 1;
			}
		}
		System.out.println(najveci);
		//prvi gotov! ><'
		
		//drugi
		
		
		int velicinaBloka = 0;
		
		for(int i = 0; i < 500; i++) {
			for(int j = 0; j < 500; j++) {
				int ukupanDistance = 0;
				for(int[] arr2 : koordinate) {
					int ai = arr2[0];
					int aj = arr2[1];
					ukupanDistance += (Math.abs(ai - i) + Math.abs(aj - j));
				}
				if(ukupanDistance < 10000) {
					velicinaBloka++;
				}
			}
		}
		System.out.println("drugi; velicina bloka : " + velicinaBloka);
}		
	
	
	
	
	
	// vracam redni broj najblize koordinate, ako su dvije najblize iste udaljenosti, vracam 0
	public static int najblizaKoordinata(int i, int j, int[][] arr, List<int[]> koordinate) {
		
		int najbliza = 0;
		int najmanjaUdaljenost = 500;
		for(int k = 0, size = koordinate.size(); k < size; k++) {
			
			int[] ko = koordinate.get(k);
			int ki = ko[0];	//
			int kj = ko[1];	// koordinate trenutne točke
			
			int trenutnaUdaljenost =  Math.abs(ki - i) + Math.abs(kj - j);
			if(trenutnaUdaljenost < najmanjaUdaljenost) {
				najbliza = k;
				najmanjaUdaljenost = trenutnaUdaljenost;
			}
		}
		
		for(int k = 0, size=koordinate.size();k<size;k++) {
			if(k!=najbliza) {
				int[] ko = koordinate.get(k);
				int ki = ko[0];	//
				int kj = ko[1];	// koordinate trenutne točke
				
				int trenutnaUdaljenost =  Math.abs(ki - i) + Math.abs(kj - j);
				if(najmanjaUdaljenost == trenutnaUdaljenost) {
					return 0;
				}
			}
		}
		return najbliza + 1;
	}

}
