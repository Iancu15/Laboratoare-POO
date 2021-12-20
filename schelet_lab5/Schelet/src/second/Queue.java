package second;

import java.util.ArrayList;

import first.Task;

public class Queue extends Container {

	@Override
	public Task pop() {
		Task task = list.remove(0);
		return task;
	}
}
