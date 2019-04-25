package marko.day7;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Sleigh2 {

	public static void main(String[] args) {
Path path = Paths.get("day7_captcha.txt");
		
		Map<String, List<String>> mapa = new HashMap<>();
		List<String> spremniZaIspis = new ArrayList<>();
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				String s1 = s.substring(36, 37); //slovo za ispis
				String s2 = s.substring(5,6);	//preduvjeti
				
				if(!mapa.containsKey(s1)) {
					List<String> lista = new ArrayList<>();
					lista.add(s2);
					mapa.put(s1, lista);
					if(!mapa.containsKey(s2)) {
						mapa.put(s2, new ArrayList<String>());
					}
				}else {
					List<String> lista = mapa.get(s1);
					lista.add(s2);
					mapa.replace(s1, lista);
					if(!mapa.containsKey(s2)) {
						mapa.put(s2, new ArrayList<String>());
					}
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		do {
			//nađi spremne za ispis
			List<Radnik> radnici= new ArrayList<>(5);
			for(int i = 0; i < 5; i++) {
				radnici.add(new Radnik());
			}
			int trenutnoIhRadi = 0;
			
			String kojiSeIspisuje;
			List<String> keyeviZaMaknit = new ArrayList<>();
			for(Entry<String,List<String>> entry : mapa.entrySet()) {
				if(entry.getValue().isEmpty()) {
					spremniZaIspis.add(entry.getKey());
					keyeviZaMaknit.add(entry.getKey());
				}
			}
			for(String s : keyeviZaMaknit) {
				mapa.remove(s);
			}
			
			
			spremniZaIspis.sort(null);
			
			kojiSeIspisuje = spremniZaIspis.get(0);
			System.out.print(kojiSeIspisuje);
			spremniZaIspis.remove(0);
			
			
			
			//sad kad je ispisan, maknuti iz preduvjeta ostalih
			for(Entry<String,List<String>> entry : mapa.entrySet()) {
				if(entry.getValue().contains(kojiSeIspisuje)) {
					entry.getValue().remove(kojiSeIspisuje);
				}
			}
			
			//pronaci nove spremne za ispis
			List<String> keyeviZaMaknit2 = new ArrayList<>();
			for(Entry<String,List<String>> entry : mapa.entrySet()) {
				if(entry.getValue().isEmpty()) {
					spremniZaIspis.add(entry.getKey());
					keyeviZaMaknit2.add(entry.getKey());
				}
			}
			for(String s1 : keyeviZaMaknit2) {
				mapa.remove(s1);
			}
			spremniZaIspis.sort(null);
			
		}while(!spremniZaIspis.isEmpty());
		
		
	}

}
