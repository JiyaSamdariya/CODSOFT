import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                return;
            }
        }
        System.out.println("Contact with name '" + name + "' not found.");
    }

    public void displayAllContacts() {
        System.out.println("All Contacts:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-30s |\n", "Name", "Phone Number", "Email Address");
        System.out.println("------------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.printf("| %-20s | %-15s | %-30s |\n", contact.getName(), contact.getPhoneNumber(), contact.getEmailAddress());
        }
        System.out.println("------------------------------------------------------------");
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found:");
                System.out.println("------------------------------------------------------------");
                System.out.printf("| %-20s | %-15s | %-30s |\n", "Name", "Phone Number", "Email Address");
                System.out.println("------------------------------------------------------------");
                System.out.printf("| %-20s | %-15s | %-30s |\n", contact.getName(), contact.getPhoneNumber(), contact.getEmailAddress());
                System.out.println("------------------------------------------------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}
