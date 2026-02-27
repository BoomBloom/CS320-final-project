package test;

import static org.junit.Assert.*;
import org.junit.Test;
import task.Task;

public class TaskTest {

    @Test
    public void testTaskCreationSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "Task Name", "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdNull() {
        new Task(null, "Task Name", "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskNameTooLong() {
        new Task("123", "This task name is definitely too long", "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskNameNull() {
        new Task("123", null, "Task Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionTooLong() {
        new Task("123", "Task Name",
                "This description is definitely way too long for the fifty character limit requirement.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionNull() {
        new Task("123", "Task Name", null);
    }

    @Test
    public void testSetNameSuccess() {
        Task task = new Task("123", "Old Name", "Desc");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescriptionSuccess() {
        Task task = new Task("123", "Name", "Old Desc");
        task.setDescription("New Desc");
        assertEquals("New Desc", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameInvalidLong() {
        Task task = new Task("123", "Name", "Desc");
        task.setName("This name is too long for the setter");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameInvalidNull() {
        Task task = new Task("123", "Name", "Desc");
        task.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionInvalidLong() {
        Task task = new Task("123", "Name", "Desc");
        task.setDescription("This description is definitely too long for the setter logic to allow it.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionInvalidNull() {
        Task task = new Task("123", "Name", "Desc");
        task.setDescription(null);
    }
}
