package lab3;

public class CandyBox {
	public String flavor;
	public String origin;
	
	public CandyBox() {
		this("undefined", "undefined");
	}
	
	public CandyBox(String flavor, String origin) {
		this.flavor = flavor;
		this.origin = origin;
	}
	
	public float getVolume() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Gust de " + flavor + ", originar din " + origin;
	}
	
	// nu am facut override si am creat o noua metoda cu parametru candybox sa nu aiba erori
	// in caz ca primeste un obiect care nu e candybox
	// verific egalitatea dintre flavor, origin si volume pentru a considera ca cele doua sunt la fel
	// nu conteaza daca e Baravelli sau ChocAmor cat timp ofera la fel de multe bomboane(volume egale)
	// de gust si origine identica
	// am folosit "==" pentru a le considera egale si cand referintele sunt diferite
	public boolean equals(CandyBox candybox) {
		if(this.flavor == candybox.flavor && this.origin == candybox.origin && this.getVolume() == candybox.getVolume()) {
			return true;
		}
		
		return false;
	}
	
	// ca sa nu-mi mai da eroare cu "candybox doesn't have a method printDim"
	// i-am lasat una goala
	public void printDim() {
	}
	
	public static void main(String[] args) {
		Lindt lindt1 = new Lindt("mere", "Singapore", 10, 10, 10);
		Lindt lindt2 = new Lindt("mere", "Singapore", 10, 10, 10);
		Lindt lindt3 = new Lindt("mere", "Singapore", 5, 20, 10);
		Lindt lindt4 = new Lindt("pere", "Singapore", 10, 10, 10);
		
		System.out.println(lindt1.equals(lindt2)); // true
		System.out.println(lindt1.equals(lindt3)); // true
		System.out.println(lindt1.equals(lindt4)); // false
	}
}
