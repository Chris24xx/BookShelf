package dev.project2.Service.Implementation;

import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.Entities.ContactUs;
import dev.project2.Exception.ContactUsNotFound;
import dev.project2.Service.Abstract.ContactUsAbstractService;

import java.util.List;

public class ContactUsServiceImp implements ContactUsAbstractService {
ContactUsAbstract contactDao;

public ContactUsServiceImp(ContactUsAbstract contactDao){
    this.contactDao = contactDao;
}

    @Override
    public ContactUs createContact(ContactUs contactUs) {
        return this.contactDao.createContact(contactUs);
    }

    @Override
    public ContactUs getContactUsById(int contactId) {
        try{
            ContactUs contactUs = this.contactDao.getContactUsById(contactId);
            return contactUs;
        } catch (ContactUsNotFound e){
            throw new ContactUsNotFound("Contact Request Not Found");
        }
    }

    @Override
    public List<ContactUs> getAllContactRequests() {
        return this.contactDao.getAllContactRequests();
    }

    @Override
    public List<ContactUs> getPendingContactRequests() {
        return this.contactDao.getPendingContactRequests();
    }

    @Override
    public List<ContactUs> getCompletedContactRequests() {
        return this.contactDao.getCompletedContactRequests();
    }

    @Override
    public boolean updateContactRequestById(int contactId) {
        return this.contactDao.updateContactRequestById(contactId);
    }

    @Override
    public boolean deleteContactRequestById(int contactId) {
        return this.contactDao.deleteContactRequestById(contactId);
    }
}
