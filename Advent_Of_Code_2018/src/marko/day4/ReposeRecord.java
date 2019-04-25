package marko.day4;

import java.nio.file.Path;  
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ReposeRecord {

	public static void main(String[] args) {
		
		List<Record> records = new LinkedList<Record>();
		Map<Integer, Guard> guards = new HashMap<Integer, Guard>();
		
		napuniRecords(records);
		sortirajRecords(records);
		napuniGuards(guards, records);
	//	ispisiRecords(records);
		
		guardsIzracunajVrijemeSpavanjaIMinute(guards);
	//	System.out.println(guards);
		
		Guard spavalica = guardKojiJeNajviseSpavao(guards);
		int id = spavalica.id;
		int minuta = spavalica.uKojojMinJeNajviseSpavao();
		
		System.out.println("id guarda: " + id);
		System.out.println("koliko je spavao ukupno: " + spavalica.vrijemeSpavanja);
		System.out.println("najcesca minuta: " + minuta);
		System.out.println("umnozak: " + id*minuta);
		
		
		najcescaIstaMinuta(guards);
	}
	
	public static void napuniRecords(List<Record> lista) {
		Path path = Paths.get("day4_captcha.txt");
	//	Path path = Paths.get("file.txt");
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split("]");
				String vrijeme = s[0].substring(1);
				String radnja = s[1].trim();
				
				String strDateFormat = "yyyy-MM-dd HH:mm";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				Date datum = sdf.parse(vrijeme);
				
				lista.add(new Record(datum, radnja));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void sortirajRecords(List<Record> lista) {
		lista.sort(null);
	}
	public static void ispisiRecords(List<Record> lista) {
		for(Record c : lista) {
			System.out.println(c);
		}
	}
	public static void napuniGuards(Map<Integer, Guard> guardovi, List<Record> zapisi) {
		Guard guard = new Guard(0);
		int id = Integer.parseInt(zapisi.get(0).radnja.trim().substring(7, 11).trim());
		for(Record zapis : zapisi) {
			String radnja = zapis.radnja;
			if(radnja.trim().startsWith("Guard")) {
				id = Integer.parseInt(radnja.trim().substring(7, 11).trim());
				
				
				if(guardovi.containsKey(id)) {
					
				}else {
					guardovi.put(id, new Guard(id));
				}
				
			}else {
		//		guardovi.get(guardovi.size() - 1).spavanjeIBudenje.add(zapis.vrijeme);
		//		guard.spavanjeIBudenje.add(zapis.vrijeme);
				guardovi.get(id).spavanjeIBudenje.add(zapis.vrijeme);
			}
			
		}
	}
	public static void guardsIzracunajVrijemeSpavanjaIMinute(Map<Integer, Guard> guardovi) {
		for(Entry<Integer, Guard> entry : guardovi.entrySet()) {
			entry.getValue().izracunajVrijemeSpavanja();	//izracunajVrijemeSpavanja();
			entry.getValue().napuniMapuMinuta();			//napuniMapuMinuta();
		}
	}
	public static Guard guardKojiJeNajviseSpavao(Map<Integer, Guard> guardovi) {
		Guard spavalica = new Guard(0);
		for(Entry<Integer, Guard> entry : guardovi.entrySet()) {
			if(entry.getValue().vrijemeSpavanja > spavalica.vrijemeSpavanja) {
				spavalica = entry.getValue();
			}
		}
		return spavalica;
	}
	
	public static void najcescaIstaMinuta(Map<Integer, Guard> guards) {
		int guardId = 0;
		int najvecaMinuta = 0;
		int pravaMinuta = 0;
		for(Entry<Integer,Guard> guard : guards.entrySet()) {
			for(Entry<Integer,Integer> minuta : guard.getValue().minute.entrySet()) {
				if(minuta.getValue() > najvecaMinuta) {
					
					najvecaMinuta = minuta.getValue();
					pravaMinuta = minuta.getKey();
					guardId = guard.getKey();
				}
			}
		}
		System.out.println("rjesenje drugog zadatka : " + guardId * pravaMinuta);
	}
	
}
