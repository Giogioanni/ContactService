package Tests;
/* 
 * Giogioanni Morales
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Contact;
import main.java.ContactService;

public class ContactServiceTest {

    private ContactService service;

    // setting ContactService instance before each test
    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    // test for adding a new contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        //verifying the contact is added correctly by retrieving it 
        assertEquals(contact, service.getContact("1"));
    }

    // test for adding a contact with a duplicate contact ID
    @Test
    public void testAddContactWithDuplicateId() {
    	// creation of 2 contact objects with the same contactID 
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // test for deleting a contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        // Verifying that the contact is deleted by checking that it cannot be retrieved
        assertNull(service.getContact("1"));
    }

    // test case updating an existing contact
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        Contact updatedContact = service.getContact("1");
        // verifying contacts details are updated correctly 
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    // test for updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Jane", "Smith", "0987654321", "456 Elm St");
        });
    }

    // extra test for adding a null contact
    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // extra test for deleting a non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
        service.deleteContact("999"); // Should not throw an exception
    }

    // extra test for updating a contact with invalid input
    @Test
    public void testUpdateContactWithInvalidInput() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", "ThisNameIsWayTooLong", null, "0987654321", "456 Elm St");
        });
    }
}
