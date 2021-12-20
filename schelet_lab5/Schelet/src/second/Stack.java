package second;

import java.util.ArrayList;

import first.Task;

public class Stack extends Container {

	@Override
	public Task pop() {
		Task task = list.remove(list.size() - 1);
		return task;
	}
}
