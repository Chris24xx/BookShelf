package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.WebUserDAO;
import dev.project2.DAO.Implementation.WebUserDAOImp;
import dev.project2.Entities.WebUser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebUserDAOTests {
    WebUserDAO webUserDAO = new WebUserDAOImp();

    @Test
    public void testCreateWebUser(){
        WebUser newWebUser = new WebUser(
                1,
                "test",
                "test",
                "someotherrandomemail@email.com",
                "ABC123",
                false
        );
        WebUser returnedWebUser = webUserDAO.createWebUser(newWebUser);
        Assert.assertTrue(returnedWebUser.getUserId() != 0);
    }

    @Test
    public void testGetWebUserById(){
        WebUser webUser = webUserDAO.getWebUserById(1);
        System.out.println(webUser);
        Assert.assertEquals(webUser.getUserId(), 1);
    }

    @Test
    public void testGetAllWebUsers(){
        List<WebUser> webUserList = webUserDAO.getAllWebUsers();
        for (WebUser i: webUserList){
            System.out.println(i);
        }
        Assert.assertTrue(webUserList.size() >= 2);
    }

    @Test
    public void testUpdateWebUser(){
        WebUser updatedWebUser = new WebUser(
                7,
                "NewFirstName",
                "OldLastName",
                "somerandomemail@email.com",
                "Pass123",
                true
        );
        WebUser returnedWebUser = webUserDAO.updateWebUser(updatedWebUser);
        Assert.assertEquals(updatedWebUser.getUserId(), returnedWebUser.getUserId());
    }

    @Test
    public void testDeleteWebUser(){
        boolean webUserDeleted = webUserDAO.deleteWebUser(9);
        Assert.assertTrue(webUserDeleted);
    }
}
