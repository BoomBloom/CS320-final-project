package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import appointment.Appointment;
import appointment.AppointmentService;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Date futureDate;

    @Before
    public void setUp() {
        service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        futureDate = cal.getTime();
    }

    @Test
    public void testAddAppointmentSuccess() {
        Appointment appointment = new Appointment("1", futureDate, "Description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAppointmentDuplicateId() {
        Appointment appointment1 = new Appointment("1", futureDate, "Description 1");
        Appointment appointment2 = new Appointment("1", futureDate, "Description 2");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
    }

    @Test
    public void testDeleteAppointmentSuccess() {
        Appointment appointment = new Appointment("1", futureDate, "Description");
        service.addAppointment(appointment);
        service.deleteAppointment("1");
        assertNull(service.getAppointment("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteAppointmentNotFound() {
        service.deleteAppointment("nonexistent");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteAppointmentNullId() {
        service.deleteAppointment(null);
    }
}
