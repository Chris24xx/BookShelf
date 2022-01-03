package dev.project2.Service.Abstract;

import dev.project2.Entities.ContactUs;

import java.util.List;

public interface ContactUsAbstractService {
    ContactUs createContact(ContactUs contactUs);

    ContactUs getContactUsById(int contactId);

    List<ContactUs> getAllContactRequests();

    List<ContactUs> getPendingContactRequests();

    List<ContactUs> getCompletedContactRequests();

    boolean updateContactRequestById(int contactId);

    boolean deleteContactRequestById(int contactId);

}
