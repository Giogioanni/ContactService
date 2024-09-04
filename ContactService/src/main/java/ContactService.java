package main.java;

import java.util.HashMap;
import java.util.Map;

//Giogioanni Morales
/*
 * ContactService class to manage contacts 
 */
public class ContactService {
    // Map to store contacts, where the key is the contactId and the value is the Contact object
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a new contact with a unique ID
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Method to delete a contact per contactID
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    // Method to update a contact
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        
        // I took out the additional validations since the Contact class setters handle them incorporating your feedback
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    // Method to retrieve a contact
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}