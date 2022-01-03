package dev.project2.Service.Implementation;

import dev.project2.Entities.ContactUs;
import dev.project2.Service.Abstract.ContactUsAbstractService;

import java.util.List;

public class ContactUsServiceImp implements ContactUsAbstractService {
    @Override
    public ContactUs createContact(ContactUs contactUs) {
        return null;
    }

    @Override
    public ContactUs getContactUsById(int contactId) {
        return null;
    }

    @Override
    public List<ContactUs> getAllContactRequests() {
        return null;
    }

    @Override
    public List<ContactUs> getPendingContactRequests() {
        return null;
    }

    @Override
    public List<ContactUs> getCompletedContactRequests() {
        return null;
    }

    @Override
    public boolean updateContactRequestById(int contactId) {
        return false;
    }

    @Override
    public boolean deleteContactRequestById(int contactId) {
        return false;
    }
}
