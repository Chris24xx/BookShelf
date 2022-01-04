package dev.project2.Service.Implementation;

import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.DAO.Implementation.ContactUsDAOImp;
import dev.project2.Exception.ContactUsNotFound;
import org.mockito.Mockito;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    }



}
