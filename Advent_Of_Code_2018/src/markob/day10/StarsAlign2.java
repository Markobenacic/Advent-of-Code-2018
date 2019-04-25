package markob.day10;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StarsAlign2 {
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("day10_captcha.txt");
		List<Point> points = new LinkedList<>();
		
		try (Scanner sc = new Scanner(path)){
			
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				String[] arr1 = s.substring(10,24).split(",");
				String[] arr2 = s.substring(36,42).split(",");
				points.add(new Point(Integer.parseInt(arr1[0].trim()), Integer.parseInt(arr1[1].trim())
							, Integer.parseInt(arr2[0].trim()), Integer.parseInt(arr2[1].trim())));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		int seconds = 1;
		while(true) {
			for(Point p : points) {
				p.move();
			}
			
			if(Math.abs(points.get(0).x - points.get(1).x) < 20) {
				int[] bla = najmanjeInajveceKoordinate(points);
				for(int i = bla[2] - 5; i < bla[3] + 5; i++) {
					for(int j = bla[0] - 5; j < bla[1] + 5; j++) {
						if(imaLiTocku(points, j, i)) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}
					System.out.println();
				}
				System.out.println(seconds);
				System.out.println();
				System.out.println();
				TimeUnit.SECONDS.sleep(1);
			}
			
			
			seconds++;
		}
		
		
	}
	public static boolean imaLiTocku(List<Point> lista, int i, int j ) {
		for(Point p : lista) {
			if (p.x==i && p.y == j) {
				return true;
			}
		}
		return false;
	}
	public static boolean distanceSvihManjiOdSto(List<Point> lista) {
		long distance = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			for(int j = i; j < lista.size(); j++) {
				distance += Math.abs(lista.get(i).x - lista.get(j).x) + Math.abs(lista.get(i).y - lista.get(j).y);
			}
		}
		if(distance < 100) return true;
		return false;
	}
	public static int[] najmanjeInajveceKoordinate(List<Point> lista) {
		int[] arr = new int[4];
		int najmanjiX = 60000;
		int najveciX = -60000;
		int najmanjiY = 60000;
		int najveciY = -60000;
		
		for(Point p : lista){
			if(p.x < najmanjiX) {
				najmanjiX = p.x;
			}
			if(p.x > najveciX) {
				najveciX = p.x;
			}
			if(p.y < najmanjiY) {
				najmanjiY = p.y;
			}
			if(p.y > najveciY) {
				najveciY = p.y;
			}
		}
		arr[0] = najmanjiX;
		arr[1] = najveciX;
		arr[2] = najmanjiY;
		arr[3] = najveciY;
		
		return arr;
	}
}
