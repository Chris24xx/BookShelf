package dev.project2.DAO.Abstract;

import dev.project2.Entities.WebUser;

import java.util.List;

public interface WebUserDAO {
    WebUser getWebUserById(int id);

    List<WebUser> getAllWebUsers();

    WebUser createWebUser(WebUser user);

    WebUser updateWebUser(WebUser user);

    boolean deleteWebUser(int id);

}
