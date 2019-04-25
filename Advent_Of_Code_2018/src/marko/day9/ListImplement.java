package marko.day9;

public class ListImplement {
	Node trenutni;
	Node prvi;
	Node zadnji;
	int size = 0;
	
	public long remove() {
		long dataZaVratit = -10000;
		for(int i = 0; i < 7; i++) {
			if(trenutni == prvi) {
				trenutni = zadnji;
			}else {
				trenutni = trenutni.last;
			}
		}
		dataZaVratit = trenutni.data;
		if(trenutni == zadnji) {
			trenutni.last.next = prvi;
			prvi.last = trenutni.last;
			trenutni = prvi;
		}else if(trenutni == prvi) {
			zadnji.next = trenutni.next;
			trenutni = trenutni.next;
			trenutni.last = zadnji;
		}else {
			trenutni.last.next = trenutni.next;
			trenutni.next.last = trenutni.last;
			trenutni = trenutni.next;
		}
		size--;
		return dataZaVratit;
	}
	public void add(int broj) {
		Node novi = new Node(broj);
		
		if(size == 0) {
			trenutni = novi;
			prvi = novi;
			zadnji = novi;
			size++;
			return;
		}else if(size == 1) {
			zadnji = novi;
			novi.last = prvi;
			novi.next = prvi;
			prvi.next = novi;
			prvi.last = novi;
			trenutni = novi;
			size++;
			return;
		}else if(size == 2) {
			prvi.next = novi;
			novi.last = prvi;
			novi.next = zadnji;
			zadnji.last = novi;
			trenutni = novi;
			size++;
			return;
		}
		
		if(trenutni.next == zadnji) {
			prvi.last = novi;
			novi.next = prvi;
			trenutni.next.next = novi;
			novi.last = trenutni.next;
			trenutni = novi;
			zadnji = novi;
		}else if(trenutni == zadnji){
			novi.last = prvi;
			novi.next = prvi.next;
			prvi.next.last = novi;
			prvi.next = novi;
			trenutni = novi;
		}else {
			novi.last = trenutni.next;
			novi.next = trenutni.next.next;
			trenutni.next.next.last = novi;
			trenutni.next.next = novi;
			trenutni = novi;
		}
		size++;
	}
}
