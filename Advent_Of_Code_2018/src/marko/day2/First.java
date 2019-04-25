package marko.day2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class First {

	public static void main(String[] args) {
		
		Path path = Paths.get("day2_captcha.txt");
		List<String> idLista = new ArrayList<>();
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				idLista.add(sc.nextLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		int twoTimes = 0;
		int threeTimes = 0;
		
		for(String s : idLista) {
			char[] arr = s.toCharArray();
			char[] abeceda = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			Map<Character, Integer> mapa = new TreeMap<>();
			
			for(int i = 0; i < abeceda.length; i++) {
				mapa.put(abeceda[i], 0);
			}
			for(int i = 0; i < arr.length; i++) {
				if(!mapa.containsKey(arr[i])) {
					mapa.put(arr[i], 0);
				}else {
					int a = mapa.get(arr[i]);
					a++;
					mapa.remove(arr[i]);
					mapa.put(arr[i], a);
				}
			}
			boolean two = false;
			boolean three = false;
			
			for(Entry<Character, Integer> entry : mapa.entrySet()) {
				if(entry.getValue() == 2) {
					two = true;
				}
				if(entry.getValue() == 3) {
					three = true;
				}
			}
			if(two) twoTimes++;
			if(three) threeTimes++;
			
		}
		int rez = twoTimes * threeTimes;
		System.out.println(rez);
		
	}

}
