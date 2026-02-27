package test;

import static org.junit.Assert.*;
import org.junit.Test;
import appointment.Appointment;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

    @Test
    public void testAppointmentCreationSuccess() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        Appointment appointment = new Appointment("1234567890", futureDate, "Test Description");
        assertNotNull(appointment);
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Test Description", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdTooLong() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        new Appointment("12345678901", futureDate, "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdNull() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        new Appointment(null, futureDate, "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInPast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date pastDate = cal.getTime();
        new Appointment("1234567890", pastDate, "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateNull() {
        new Appointment("1234567890", null, "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        String longDescription = "This description is definitely longer than fifty characters to test validation.";
        new Appointment("1234567890", futureDate, longDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        new Appointment("1234567890", futureDate, null);
    }
}
