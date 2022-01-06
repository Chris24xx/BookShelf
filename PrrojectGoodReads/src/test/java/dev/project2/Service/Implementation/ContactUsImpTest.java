package dev.project2.Service.Implementation;

import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.DAO.Implementation.ContactUsDAOImp;
import dev.project2.Entities.ContactUs;
import dev.project2.Exception.ContactUsNotFound;
import dev.project2.Exception.ListCanNotBeGenerated;
import org.mockito.Mockito;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ContactUsImpTest {
    static ContactUsDAOImp contactDao;
    static ContactUsServiceImp contactUsServiceImp;

    @BeforeClass
    public void setup(){
        contactDao = Mockito.mock(ContactUsDAOImp.class);
        contactUsServiceImp = new ContactUsServiceImp(contactDao);
    }

    @Test(expectedExceptions = ContactUsNotFound.class, expectedExceptionsMessageRegExp = "Contact Request Not Found" )
    void getContactRequestFail(){
        Mockito.when(contactDao.getContactUsById(100)).thenThrow(new ContactUsNotFound("Contact Request Not Found"));
        ContactUs contactUs = contactUsServiceImp.getContactUsById(100);
    }

    @Test(expectedExceptions = ListCanNotBeGenerated.class, expectedExceptionsMessageRegExp = "List cannot be generated at this time")
    void getCompletedContactRequestsFail(){
        Mockito.when(contactDao.getCompletedContactRequests()).thenThrow(new ListCanNotBeGenerated("List cannot be generated at this time"));
        List<ContactUs> contactUsList = contactUsServiceImp.getCompletedContactRequests();
    }

    @Test(expectedExceptions = ListCanNotBeGenerated.class, expectedExceptionsMessageRegExp = "List cannot be generated at this time")
    void getAllContactRequestsFail(){
        Mockito.when(contactDao.getAllContactRequests()).thenThrow(new ListCanNotBeGenerated("List cannot be generated at this time"));
        List<ContactUs> contactUsList = contactUsServiceImp.getAllContactRequests();
    }

    @Test(expectedExceptions = ListCanNotBeGenerated.class, expectedExceptionsMessageRegExp = "List cannot be generated at this time")
    void getPendingContactRequestsFail(){
        Mockito.when(contactDao.getPendingContactRequests()).thenThrow(new ListCanNotBeGenerated("List cannot be generated at this time"));
        List<ContactUs> contactUsList = contactUsServiceImp.getPendingContactRequests();
    }

}
