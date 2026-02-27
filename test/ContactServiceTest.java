package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {
    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContactId() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak St");
        service.addContact(contact1);
        service.addContact(contact2);
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteContactNotFound() {
        service.deleteContact("1");
    }

    @Test
    public void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1", "Jane");
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastNameSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1", "Smith");
        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhoneSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1", "0987654321");
        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddressSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1", "456 Oak St");
        assertEquals("456 Oak St", service.getContact("1").getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentContact() {
        service.updateFirstName("1", "Jane");
    }
}
