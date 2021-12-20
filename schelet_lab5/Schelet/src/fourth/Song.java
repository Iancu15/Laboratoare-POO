package fourth;

public class Song {
	public String name;
	public Integer id;
	public String composer;
	
	public Song(String name, int id, String composer) {
		this.name = name;
		this.id = id;
		this.composer = composer;
	}
	
	public boolean isPrime() {
		if (id < 2) {
			return false;
		}
		
		for(int i = 2; i < id; i++) {
			if (id % i == 0)
				return false;
		}
		
		return true;
	}
	
	public boolean isPalindrom() {
		int number = this.id;
		int number_reverse = 0;
		while(number != 0) {
			number_reverse = number_reverse * 10 +  number % 10;
			number = number / 10;
		}
		
		return true;
	}
}
