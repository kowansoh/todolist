import java.util.Collection;
import java.util.Scanner;

public class TaskListMainMenu{

  public static void main (String[] args)
  {
	  
	int option;
	int taskNum;
	String description;
	String newDescription;
	String deleteConfirmation;
	String searchQuery;
	Controller controller = new Controller();
	
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
	    displayMenu();
	    System.out.print("Enter your option: ");
	    option = scanner.nextInt();
	    
	    if(option == 1) {
	    	System.out.println();
	    	System.out.println("<<<<< Add Task >>>>>");
	    	System.out.println("Enter the description: ");
	    	scanner.nextLine();
	    	description = scanner.nextLine();
	    	controller.addTask(description);
	    }
	    
	    if(option == 2) {
	    	System.out.println();
	    	System.out.println("<<<<< Edit Task >>>>>");
	    	System.out.println("This is your task list:");
	    	print(controller.getAllTask());
	    	
	    	System.out.println("Enter task number to edit: ");
	    	taskNum = scanner.nextInt();
	    	System.out.println("Enter the new description: ");
	    	newDescription = scanner.next();
	    	controller.editTaskDescription(taskNum, newDescription);
	    }
	    
	    if(option == 3) {
	    	System.out.println();
	    	System.out.println("<<<<< Delete Task >>>>>");
	    	System.out.println("This is your task list:");
	    	print(controller.getAllTask());
	    	
	    	System.out.println("Enter task number: ");
	    	taskNum = scanner.nextInt();
	    	System.out.println("Are you sure (Y/N): ");
	    	deleteConfirmation = scanner.next();
	    	controller.deleteTask(taskNum, deleteConfirmation);
	    }
	    
	    if(option == 4) {
	    	System.out.println();
	    	System.out.println("<<<<< View Task >>>>>");
	    	System.out.println("This is your task list:");
	    	print(controller.getAllTask());
	    }
	    
	    if(option == 5) {
	    	System.out.println();
	    	System.out.println("<<<<< Search Task >>>>>");
	    	System.out.println("Enter description to search: ");
	    	scanner.nextLine();
	    	searchQuery = scanner.nextLine();
	    	Collection<Task> tasks = controller.search(searchQuery);
	    	print(tasks);
	    }
	    
	    if(option == 6) {
	    	break;
	    }
	    
	    System.out.println("Your request has been updated!");
    }
    
  }
  
  public static void displayMenu() {
		System.out.println("---------------------------------");
		System.out.println("1. Add Task");
		System.out.println("2. Edit Task");
		System.out.println("3. Delete Task");
		System.out.println("4. View Task");
		System.out.println("5. Search Task");
		System.out.println("6. Exit");
		System.out.println("---------------------------------");
  }
  
  public static void print(Collection<Task> tasks) {
	int i = 1;
	if(tasks.isEmpty())
	{
		System.out.println("No Tasks.");
	} else {
		for(Task task:tasks) {
			System.out.print(i +". ");
			print(task);
			i++;
		}
	}
	System.out.println("");
  }
	
  public static void print(Task task) {
	System.out.print("Description: "+task.getDescription() +" \n");
  }

}