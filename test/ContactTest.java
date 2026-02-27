package test;

import static org.junit.Assert.*;
import org.junit.Test;
import contact.Contact;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact("1", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull() {
        new Contact("1", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact("1", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameNull() {
        new Contact("1", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneInvalidLength() {
        new Contact("1", "John", "Doe", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong() {
        new Contact("1", "John", "Doe", "12345678901", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNotDigits() {
        new Contact("1", "John", "Doe", "12345abcde", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNull() {
        new Contact("1", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact("1", "John", "Doe", "1234567890", "123 Main St, Apt 101, Springfield, IL 62704");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressNull() {
        new Contact("1", "John", "Doe", "1234567890", null);
    }
}
