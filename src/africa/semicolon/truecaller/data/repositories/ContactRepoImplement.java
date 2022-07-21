package africa.semicolon.truecaller.data.repositories;

import africa.semicolon.truecaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepoImplement implements ContactRepository{
    private List<Contact> contacts = new ArrayList<>();
    private int counter;
    @Override
    public Contact save(Contact contact) {
        counter++;
        for (var myContact : contacts){
            if (contact.getId()==myContact.getId()){
                counter = counter;
            }
        }
        contact.setId(counter);
        contacts.add(contact);
        return contact;
    }

    @Override
    public void delete(Contact contact) {
//        contacts.removeIf(myContact -> myContact == contact);
        for (var contactFind : contacts){
            if (contactFind == contact){
                contacts.remove(contactFind);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Contact contact= findById(id);
        contacts.remove(contact);
        System.out.println("Contact deleted successfully");

    }

    @Override
    public Contact findById(int id) {
        for (var contact : contacts){
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        for (var contact : contacts){
            if (contact.getFirstName() == firstName){
                return contacts;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        for (var contact : contacts){
            if (contact.getLastName() == lastName){
                return contacts;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public int count() {
        return contacts.size();
    }
}
