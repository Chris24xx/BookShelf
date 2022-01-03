package dev.project2.DAO.Implementation;
import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.Entities.ContactUs;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class ContactUsImpTest {
    ContactUsAbstract dao = new ContactUsDAOImp();

    @Test
    public void testCreateContactUs(){
        ContactUs contactUs = new ContactUs(1,"wherever@yahoo.com", "Amanda Gonzalez", "I am having..." );
        ContactUs returnedContactUs = dao.createContact(contactUs);
        Assert.assertTrue(returnedContactUs.getContactId()==1);
    }

}
