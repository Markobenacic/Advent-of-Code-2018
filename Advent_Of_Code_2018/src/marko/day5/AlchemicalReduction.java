package marko.day5;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlchemicalReduction {
	
	//  ***************************
	//	*********ATTENTION*********
	//	*********EYE HAZARD********
	//  ***************************
	

	public static void main(String[] args) {
		
		
		Path path = Paths.get("day5_captcha.txt");
		String s = "";
		
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNext()) {
				s = sc.next();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<String> lista = new ArrayList<>();
		
		int n = s.length();
		
		for(int i = 0; i<n; i++) {
			lista.add(s.substring(i, i+1));
		}
		List<String> pomocnaLista = new ArrayList<>(lista);
		
		boolean promjena = true;
		outerloop:
		while(promjena) {
			promjena = false;
			for(int i = 0, m = lista.size(); i < m - 1; i++) {
				if(unistavamLi(lista.get(i),lista.get(i+1))) {
					promjena = true;
					lista.remove(i);
					lista.remove(i);
					continue outerloop;
				}
			}
		}
		System.out.println("units remained: " + lista.size());
		
		String abeceda = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 26; i++) {
			odradiZaSlovoAbecede(pomocnaLista, abeceda.substring(i, i+1));
		}
	}
	public static boolean unistavamLi(String a, String b) {
		if(a.equals(b)) return false;
		if(a.toLowerCase().equals(b.toLowerCase())) {
			return true;
		}
		return false;
	}
	public static void odradiZaSlovoAbecede(List<String> l, String slovo) {
		System.out.println("slovo "+ slovo + ": ");
		List<String> novaLista = new ArrayList<>(l);
		boolean ostaje = true;
		loopanje:
		while(ostaje) {
			ostaje = false;
			for(int i = 0, m = novaLista.size(); i < m; i++) {
				if (novaLista.get(i).toLowerCase().equals(slovo)) {
					novaLista.remove(i);
					ostaje = true;
					continue loopanje;
				}
			}
		}
		
		boolean promjena = true;
		outerloop:
		while(promjena) {
			promjena = false;
			for(int i = 0, m = novaLista.size(); i < m - 1; i++) {
				if(unistavamLi(novaLista.get(i),novaLista.get(i+1))) {
					promjena = true;
					novaLista.remove(i);
					novaLista.remove(i);
					continue outerloop;
				}
			}
		}
		System.out.println("units remained: " + novaLista.size());
	}
}
