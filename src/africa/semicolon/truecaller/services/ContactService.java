package africa.semicolon.truecaller.services;

import africa.semicolon.truecaller.data.models.Contact;

public class ContactService implements iContactService {
    public Contact addNewContact(Contact contact){
        return new Contact();
    }
}
