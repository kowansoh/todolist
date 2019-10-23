import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	// Define Test Fixtures
	private Controller controller;

	public ControllerTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		controller = new Controller();
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testAddTask() {
		assertNotNull(controller);
		String taskDescription = "task 1";
		controller.addTask(taskDescription);
		Task task = controller.getTask(taskDescription);
		assertEquals(taskDescription, task.getDescription());
	}
	
	@Test
	public void testDeleteTask() {
		assertNotNull(controller);
		String taskDescription = "task 1";
		controller.addTask(taskDescription);
		assertTrue(controller.getAllTask().size() == 1);
		controller.deleteTask(20, "Y");
		assertTrue(controller.getAllTask().size() == 1);
		controller.deleteTask(0,  "N");
		assertTrue(controller.getAllTask().size() == 1);
		controller.deleteTask(0, "Y");
		assertTrue(controller.getAllTask().size() == 0);
	}
}
