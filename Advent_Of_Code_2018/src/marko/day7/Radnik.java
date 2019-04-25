package marko.day7;

public class Radnik {
	int counter = 0;
	int countTo;
	String slovo;
	
	public Radnik() {
		
	}
	public void setup(String slovo) {
		this.slovo = slovo;
		char s = slovo.charAt(0);
		this.countTo = (int)s - 64 + 60;
	}
	public boolean count() {
		this.counter++;
		return isDone();
	}
	public boolean isDone() {
		if (counter < countTo) {
			return false;
		}else if(counter == countTo) {
			return true;
		}else {
			throw new IndexOutOfBoundsException();
		}
	}
}
