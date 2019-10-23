import java.util.ArrayList;
import java.util.Collection;

public class Controller {
	private ToDoList toDoList;
	
	public Controller () {
		toDoList = new ToDoList();
	}
	
	public void addTask(String desc) {
		Task task = new Task(desc);
		toDoList.addTask(task);
	}
	
	public Collection<Task> getAllTask() {
		return toDoList.getAllTasks();
	}
	public Task getTask(String desc) {
		return toDoList.getTask(desc);
	}
	
	public void editTaskDescription(int index, String description) {
		Task task = getTaskUsingIndex(index);
		toDoList.editTaskDescription(task, description);
	}
	
	public void deleteTask(int index,String decision) {
		Task task = getTaskUsingIndex(index);
		if(decision == "Y")
			toDoList.removeTask(task.getDescription());
	}
	
	private Task getTaskUsingIndex(int index) {
		ArrayList<Task> tasks = (ArrayList<Task>)toDoList.getAllTasks();
		Task task = tasks.get(index);
		return task;
	}
}
