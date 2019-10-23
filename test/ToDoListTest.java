import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task uncompletedTask1,completedTask1;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		uncompletedTask1 = new Task("UTask1",false);
		completedTask1 = new Task("CTask1",true);
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
	}

	@Test
	public void testAddTask() {
		ToDoList todoList = new ToDoList();
		todoList.addTask(uncompletedTask1);
		
		assertEquals(todoList.getAllTasks().size(),1);
		assertSame(todoList.getTask(uncompletedTask1.getDescription()),uncompletedTask1);
	}
	@Test
	public void testgetStatus() {
		ToDoList todoList = new ToDoList();
		todoList.addTask(uncompletedTask1);
		
		assertFalse(todoList.getStatus(uncompletedTask1.getDescription()));
		todoList.addTask(completedTask1);
		
		assertTrue(todoList.getStatus(completedTask1.getDescription()));
	}
	@Test
	public void testCompleteTask() {
		ToDoList todoList = new ToDoList();
		todoList.addTask(uncompletedTask1);
		
		todoList.completeTask(uncompletedTask1.getDescription());
		
		assertTrue(todoList.getStatus(uncompletedTask1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		ToDoList todoList = new ToDoList();
		todoList.addTask(completedTask1);
		todoList.addTask(uncompletedTask1);
		
		// Check if both task got added
		assertEquals(todoList.getAllTasks().size(),2);
		
		Task removed = todoList.removeTask(completedTask1.getDescription());
		
		assertEquals(removed,completedTask1);
		assertEquals(todoList.getAllTasks().size(),1);
	}
	@Test
	public void testGetCompletedTasks() {
		ToDoList todoList = new ToDoList();
		
		todoList.addTask(uncompletedTask1);

		assertEquals(todoList.getCompletedTasks().size(),0);
		
		todoList.addTask(completedTask1);
		
		assertEquals(todoList.getCompletedTasks().size(),1);
	}
	@Test
	public void testEditTasksDesciption() {
		ToDoList todoList = new ToDoList();
		
		todoList.addTask(uncompletedTask1);

		assertEquals("UTask1", uncompletedTask1.getDescription());
		
		todoList.editTaskDescription(uncompletedTask1, "UTask2");
		
		assertEquals("UTask2", uncompletedTask1.getDescription());
	}
	
	@Test
	public void testSearchPartial() {
		ToDoList todoList = new ToDoList();
		assertTrue(todoList.searchPartial("UT").isEmpty());
		todoList.addTask(uncompletedTask1);
		assertFalse(todoList.searchPartial("UT").isEmpty());
		assertFalse(todoList.searchPartial("ut").isEmpty());
		assertTrue(todoList.searchPartial("").isEmpty());
		todoList.addTask(completedTask1);
		assertEquals(1, todoList.searchPartial("ut").size());
	}
}
