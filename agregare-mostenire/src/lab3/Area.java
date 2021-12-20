package lab3;

public class Area {
	public CandyBag candybag;
	public int number;
	public String street;
	
	public Area() {
		this(null, 0, "undefined");
	}
	
	public Area(CandyBag candybag, int number, String street) {
		this.candybag = candybag;
		this.number = number;
		this.street = street;
	}
	
	public void cuinstanceof(CandyBag candybag) {
		for(CandyBox candybox : candybag.candyboxes) {
			if(candybox instanceof ChocAmor) {
				((ChocAmor) candybox).printChocAmorDim();
			} else if (candybox instanceof Lindt) {
				((Lindt) candybox).printLindtDim();
			} else {
				((Baravelli) candybox).printBaravelliDim();
			}
		}
	}
	
	public void farainstanceof(CandyBag candybag) {
		for(CandyBox candybox : candybag.candyboxes) {
			candybox.printDim();
		}
	}
	
	public void getBirthdayCard() {
		System.out.println("Strada " + street + ", numarul " + number + "\n" + "La multi ani!");
		System.out.println(candybag); // deja apelez in CandyBag fiecare element prin metoda toString
		
		this.farainstanceof(this.candybag);
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
		
		Area area = new Area(candybag, 15, "Vizitiu");
		area.getBirthdayCard();
	}
}
