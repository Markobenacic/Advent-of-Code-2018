package marko.day2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		
		Path path = Paths.get("day2_captcha.txt");
		List<String> lista1 = new ArrayList<>();	// 
		List<String> lista2 = new ArrayList<>();	// 
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				lista1.add(sc.nextLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		lista2.addAll(lista1);
		
		//algoritam
		int index1 = 0;
		int index2 = 0;
		
		int n = lista1.size();
		outerloop:
		for(int i = 0; i<n; i++) {
			for(int j = i + 1; j < n; j++) {
				char arr1[] = lista1.get(i).toCharArray();
				char arr2[] = lista2.get(j).toCharArray();
				int arrSize = arr1.length;
				
				int brojRazlicitih = 0;
				for(int k = 0; k < arrSize; k++ ) {
					if(arr1[k] != arr2[k]) {
						brojRazlicitih++;
					}
				}
				if(brojRazlicitih == 1) {
					index1 = i;
					index2 = j;
					break outerloop;
				}
			}
		}
		System.out.println(lista1.get(index1));
		System.out.println(lista2.get(index2));
		
		System.out.println("kad se oduzme to jedno slovo:");
		
		//automatiziraj oduzimanje slova:
		
		
		
	}

}
