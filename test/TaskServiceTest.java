package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import task.Task;
import task.TaskService;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTaskSuccess() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("1"));
        assertEquals(task, taskService.getTask("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTaskId() {
        Task task1 = new Task("1", "Name 1", "Description 1");
        Task task2 = new Task("1", "Name 2", "Description 2");
        taskService.addTask(task1);
        taskService.addTask(task2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskNull() {
        taskService.addTask(null);
    }

    @Test
    public void testDeleteTaskSuccess() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteTaskNotFound() {
        taskService.deleteTask("nonexistent");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteTaskNull() {
        taskService.deleteTask(null);
    }

    @Test
    public void testUpdateTaskSuccess() {
        Task task = new Task("1", "Old Name", "Old Description");
        taskService.addTask(task);
        taskService.updateTask("1", "New Name", "New Description");
        assertEquals("New Name", taskService.getTask("1").getName());
        assertEquals("New Description", taskService.getTask("1").getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskNotFound() {
        taskService.updateTask("nonexistent", "Name", "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskInvalidName() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        taskService.updateTask("1", "Too long name for this update", "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskInvalidDescription() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        taskService.updateTask("1", "Name",
                "This description is definitely way too long for the fifty character limit requirement.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskNullName() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        taskService.updateTask("1", null, "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskNullDescription() {
        Task task = new Task("1", "Name", "Description");
        taskService.addTask(task);
        taskService.updateTask("1", "Name", null);
    }
}
