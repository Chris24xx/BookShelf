package dev.project2.Service.Implementation;

import dev.project2.DAO.Implementation.WebUserDAOImp;
import dev.project2.Entities.WebUser;
import dev.project2.Exception.WebUserNotFound;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebUserServiceTests {
    static WebUserDAOImp webUserDAOImp;
    static WebUserServiceImp webUserServiceImp;

    @BeforeClass
    public void setup(){
        webUserDAOImp = Mockito.mock(WebUserDAOImp.class);
        webUserServiceImp = new WebUserServiceImp(webUserDAOImp);
    }

    @Test(expectedExceptions = WebUserNotFound.class, expectedExceptionsMessageRegExp = "WebUser not found")
    public void testMakeModeratorFail(){
        Mockito.when(webUserDAOImp.getWebUserById(2)).thenThrow(new WebUserNotFound("WebUser not found"));
        WebUser webUser = webUserServiceImp.makeModerator(true, 2);
    }

    @Test
    public void testMakeModeratorPass(){
        WebUser updatedWebUser = new WebUser(
                1,
                "test",
                "test",
                "someotherrandomemail@email.com",
                "ABC123",
                true);
        Mockito.when(webUserDAOImp.getWebUserById(1)).thenReturn(new WebUser(
                1,
                "test",
                "test",
                "someotherrandomemail@email.com",
                "ABC123",
                false));
        Mockito.when(webUserDAOImp.updateWebUser(updatedWebUser)).thenReturn(updatedWebUser);
        WebUser webUser = webUserServiceImp.makeModerator(true, 1);
    }
}
