package first;

public class OutTask implements Task {
	private String mesaj;
	public OutTask(String mesaj) {
		this.mesaj = mesaj;
	}
	
	public void execute() {
		System.out.println(this.mesaj);
	}
}
