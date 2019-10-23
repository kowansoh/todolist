import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
		if(decision.equalsIgnoreCase("Y"))
			toDoList.removeTask(task.getDescription());
	}
	
	private Task getTaskUsingIndex(int index) {
		Iterator<Task> iteratorTask = toDoList.getAllTasks().iterator();
		ArrayList<Task> tasks = new ArrayList<Task>();
		while(iteratorTask.hasNext()) {
			tasks.add(iteratorTask.next());
		}
		Task task = tasks.get(index-1);
		return task;
	}
	
	public Collection<Task> search(String description){
		Collection<Task> tasks = toDoList.searchPartial(description);
		return tasks;
	}
}
