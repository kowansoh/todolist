import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		//Add code here
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		// Add code here
		Task task = getTask(description);
		task.setComplete(true);
	}
	public boolean getStatus(String description) {
		
		return tasks.get(description).isComplete();
	}
	public Task getTask(String description) {
		// Add code here
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		Task removed = tasks.remove(description);
		return removed;
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task>();
		for(Task task:getAllTasks()) {
			if(task.isComplete())
				completedTasks.add(task);
		}
		return completedTasks;
	}
	public void print(Collection<Task> tasks) {
		for(Task task:tasks) {
			print(task);
		}
	}
	
	public void print(Task task) {
		System.out.print("Description"+task.getDescription() +" \n");
	}

	public void editTaskDescription(Task task, String description) {
		task.setDescription(description);
	}
}
