package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepoImplementTest {
    @Test
    public void saveTest(){
        ContactRepository contact = new ContactRepoImplement();
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("083562526");
        contact1.setEmail("Ojo");
        contact1.setFirstName("Ojo");
        contact1.setLastName("Gbade");
        contact.save(contact1);
        assertEquals(1, contact.count());
    }

    @Test
    public void findSavedContactByFirstName(){
        ContactRepository contact = new ContactRepoImplement();
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("083562526");
        contact1.setEmail("Ojo@yahoo.com");
        contact1.setFirstName("Ojo");
        contact1.setLastName("Gbade");
        contact.save(contact1);
        assertEquals(1, contact.count());
        Contact saveContact = contact.findById(1);
        assertEquals("Ojo", saveContact.getFirstName());
    }
    @Test
    public void DeleteSaveContact(){
        ContactRepository contact = new ContactRepoImplement();
        Contact contact1 = new Contact();

        contact1.setPhoneNumber("083962526");
        contact1.setEmail("Ayo@gmail.com");
        contact1.setFirstName("Balogun");
        contact1.setLastName("Gbade");

        contact.save(contact1);

        contact.delete(contact1);

        assertEquals(0, contact.count());

    }
    @Test
    public void updateContactTest(){
        ContactRepository contact = new ContactRepoImplement();
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("083962526");
        contact1.setEmail("Temi@gmail.com");
        contact1.setFirstName("Laolu");
        contact1.setLastName("Gbadebo");
        contact.save(contact1);
        contact1.setFirstName("Teminikan");
        assertEquals("Teminikan", contact1.getFirstName());
        assertEquals("Gbadebo", contact1.getLastName());
    }
}