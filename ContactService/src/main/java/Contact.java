package main.java;
/* 
 * Giogioanni Morales
 */

public class Contact {
    private static final int MAX_ID_LENGTH = 10; // Maximum length for contact ID
    private static final int MAX_NAME_LENGTH = 10; // Maximum length for first and last names
    private static final int PHONE_LENGTH = 10; // Expected length for phone number
    private static final int MAX_ADDRESS_LENGTH = 30; // Maximum length for address
    
    private final String contactId; // Immutable contact ID
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = validateContactId(contactId); // Validate and assign contactId
        this.firstName = validateFirstName(firstName); // Validate and assign firstName
        this.lastName = validateLastName(lastName); // Validate and assign lastName
        this.phone = validatePhone(phone); // Validate and assign phone
        this.address = validateAddress(address); // Validate and assign address
    }

    // Getter contactId
    public String getContactId() {
        return contactId;
    }

    // Getter and setter for first name
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = validateFirstName(firstName); // Validate and update firstName
    }

    // Getter and setters for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = validateLastName(lastName); // Validate and update lastName
    }

    // Getter and setter for phone
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = validatePhone(phone); // Validate and update phone
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = validateAddress(address); // Validate and update address
    }

    // Validation Methods

    // Validate contactId: must not be null and length <= MAX_ID_LENGTH (10)
    private String validateContactId(String contactId) {
        if (contactId == null || contactId.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        return contactId;
    }

    // Validate firstName: must not be null and length <= MAX_NAME_LENGTH
    private String validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Invalid first name");
        }
        return firstName;
    }

    // Validate lastName: must not be null and length <= MAX_NAME_LENGTH
    private String validateLastName(String lastName) {
        if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Invalid last name");
        }
        return lastName;
    }

    // Validate phone: must not be null, length must be PHONE_LENGTH, and must contain only digits
    private String validatePhone(String phone) {
        if (phone == null || phone.length() != PHONE_LENGTH || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        return phone;
    }

    // Validate address: must not be null and length <= MAX_ADDRESS_LENGTH
    private String validateAddress(String address) {
        if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Invalid address");
        }
        return address;
    }
}