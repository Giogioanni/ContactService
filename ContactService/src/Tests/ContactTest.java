package Tests;
/* 
 * Giogioanni Morales 
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.Contact;

public class ContactTest {

    // test for creating a valid contact
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // these tests include CREATING contacts with setting null firstName, setting lastName to exceed maximum length, setting phone number with incorrect length, and setting a null address.
    @Test
    public void testInvalidContactCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345678", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null);
        });
    }

    // tests for updating contact details
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");
     // Verification of parameters is updated correctly 
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    // test for updating contact details with invalid input
    @Test
    public void testInvalidUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        // these tests include UPDATE setting null firstName, setting lastName to exceed maximum length, setting phone number with incorrect length, and setting a null address.
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("TestingForWayTooLongName");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    // extra test for checking immutability of contactId
    @Test
    public void testContactIdImmutability() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactId());

     // updates other fields of the contact
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");
       // makes sure the contactID remains unchanged
        assertEquals("1", contact.getContactId());
    }
}