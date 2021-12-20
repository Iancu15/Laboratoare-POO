package lab3;

import java.util.ArrayList;

public class CandyBag {
	public ArrayList<CandyBox> candyboxes;
	
	public CandyBag(int n) {
		this.candyboxes = new ArrayList<CandyBox>(n);
	}
	
	public CandyBag() {
		this.candyboxes = new ArrayList<CandyBox>(0);
	}
	
	public void add(CandyBox candybox) {
		this.candyboxes.add(candybox);
	}
	
	@Override
	public String toString() {
		String strings = "";
		for(CandyBox candybox : this.candyboxes) {
			String string = candybox.toString() + "\n";
			strings = strings.concat(string);
		}
		
		return strings;
	}
	
	public static void main(String[] args) {
		Lindt lindt1 = new Lindt("mere", "Singapore", 10, 10, 10);
		Lindt lindt2 = new Lindt("prune", "Singapore", 10, 10, 10);
		Lindt lindt3 = new Lindt("fructul pasiunii", "Singapore", 5, 20, 10);
		Lindt lindt4 = new Lindt("pere", "Singapore", 10, 10, 10);
		ChocAmor chocamor = new ChocAmor("portocale", "Singapore", 10);
		Baravelli baravelli = new Baravelli("portocale", "Singapore", 10, 10);
		
		// merge si fara parametru ca e arraylist
		CandyBag candybag = new CandyBag();
		candybag.add(lindt1);
		candybag.add(lindt2);
		candybag.add(lindt3);
		candybag.add(lindt4);
		candybag.add(chocamor);
		candybag.add(baravelli);
		
		System.out.println(candybag.toString());
	}
}
