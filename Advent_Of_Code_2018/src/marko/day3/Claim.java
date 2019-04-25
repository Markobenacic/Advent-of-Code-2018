package marko.day3;

public class Claim {
	int id;
	int leftEdge;
	int topEdge;
	int width;
	int height;
	
	public Claim(int id, int leftEdge, int topEdge, int width, int height) {
		this.id = id;
		this.leftEdge = leftEdge;
		this.topEdge = topEdge;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "#" + id + " @ " + leftEdge + "," + topEdge + ": " + width + "x" + height;
	}
}
