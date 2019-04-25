package marko.day4;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Guard {
	int id;
	int vrijemeSpavanja = 0;
	List<Date> spavanjeIBudenje = new LinkedList<Date>();
	Map<Integer, Integer> minute = new LinkedHashMap<Integer, Integer>();
	
	public Guard(int id) {
		this.id = id;
		for(int i = 0; i < 60; i++) {
			minute.put(i, 0);
		}
	}
	public void izracunajVrijemeSpavanja() {
		int zaspo = 0;
		int probudio = 0;
		int i = 0;
		for(Date d : spavanjeIBudenje) {
			if (i%2 == 0) {
				
				zaspo = d.getMinutes();
			//	System.out.println(id + " zaspo: " + zaspo);
			}if(i%2 == 1) {
				probudio = d.getMinutes();
			//	System.out.println(id + " probudio: " + probudio);
				this.vrijemeSpavanja = this.vrijemeSpavanja +  (probudio - zaspo);
			}
			i++;
			
		}
		
	}
	public void napuniMapuMinuta() {
		int zaspo = 0;
		int probudio = 0;
		int i = 0;
		for(Date d : spavanjeIBudenje) {
			if(i%2 == 0) {
				zaspo = d.getMinutes();
			}
			if(i%2 == 1) {
				probudio = d.getMinutes();
				for(int n = zaspo ; n <  probudio ;n++) {
					minute.put(n, minute.get(n) + 1);
				}
			}
			i++;
		}
	}
	public int uKojojMinJeNajviseSpavao() {
		int broj = minute.get(0);
		int index = 0;
		for(int i = 1; i < 60; i++) {
			if(minute.get(i) > broj) {
				broj = minute.get(i);
				index = i;
			}
		}
		return index;
	}
	@Override
	public boolean equals(Object obj) {
		Guard o = (Guard) obj;
		return this.id == o.id;
	}
	
	@Override
	public String toString() {
		return  spavanjeIBudenje.toString() + "\n"; //spavanjeIBudenje.toString();
	}
}
