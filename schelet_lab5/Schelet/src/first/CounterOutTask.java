package first;

public class CounterOutTask implements Task{
	static int contor = 0;
	public void execute() {
		CounterOutTask.contor++;
		System.out.println("" + contor);
	}
}
