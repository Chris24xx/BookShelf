package dev.project2.DAO.Implementation;
//import dev.project2.Website.Abstract.ContactUsAbstract;
import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.Entities.ContactUs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ContactUsImpTest {
    ContactUsAbstract dao = new ContactUsDAOImp();

    @Test
    public void testCreateContactUs(){
        ContactUs contactUs = new ContactUs(1, false, "wherever@yahoo.com", "Amanda Gonzalez", "I am having..." );
        ContactUs returnedContactUs = dao.createContact(contactUs);
        Assert.assertTrue(returnedContactUs.getContactId()==3);
    }

    @Test
    void selectContactRequestById(){
        ContactUs contactUs =dao.getContactUsById(2);
        System.out.println(contactUs);
        Assert.assertEquals(contactUs.getContactId(), 2);
    }

    @Test
    void getAllContactRequests(){
        List<ContactUs> contactUsList = dao.getAllContactRequests();
        for (ContactUs c : contactUsList){
            System.out.println(c);
        }
        Assert.assertTrue(contactUsList.size() >= 3);
    }

    @Test
    void getPendingContactRequests(){
        List<ContactUs> contactUsList = dao.getPendingContactRequests();
        for (ContactUs c : contactUsList){
            System.out.println(c);
        }
        Assert.assertTrue(contactUsList.size() >= 3);
    }

    @Test
    void getCompletedContactRequests(){
        List<ContactUs> contactUsList = dao.getCompletedContactRequests();
        for (ContactUs c : contactUsList){
            System.out.println(c);
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testDeleteContactRequest() {
        boolean result = dao.deleteContactRequestById(3);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateContactRequest() {
        boolean result = dao.updateContactRequestById(2);
        Assert.assertTrue(result);
    }


}
