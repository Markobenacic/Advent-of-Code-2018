package markob.day10;

public class Point {
	public int x;
	public int y;
	public int dx;
	public int dy;
	
	public Point(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public String toString() {
		return "|" + "<" + x + "," + y + ">  <" + dx + "," + dy + ">" + "|";
	}
	
	public void normalise() {
		this.x = x/150;
		this.y = y / 150;
		this.dx = dx / 150;
		this.dy = dy / 150;
	}
	public void move() {
		this.x += this.dx;
		this.y += this.dy;
	}
}
