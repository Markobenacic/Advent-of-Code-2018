package marko.day4;

import java.util.Date;

public class Record implements Comparable<Record>{
	Date vrijeme;
	String radnja;
	
	public Record (Date vrijeme, String radnja) {
		this.vrijeme = vrijeme;
		this.radnja = radnja;
	}
	
	@Override
	public String toString() {
		return "[" + vrijeme.toString() + "] " + radnja;
	}

	@Override
	public int compareTo(Record o) {
		return this.vrijeme.compareTo(o.vrijeme);
	}
}
