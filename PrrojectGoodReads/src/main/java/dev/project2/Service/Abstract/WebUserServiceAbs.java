package dev.project2.Service.Abstract;

import dev.project2.Entities.WebUser;

import java.util.List;

public interface WebUserServiceAbs {
    WebUser makeModerator(Boolean mod, int id);

    WebUser getWebUserByIdService(int id);

    List<WebUser> getAllWebUsers();

    WebUser createWebUser(WebUser webUser);

    WebUser updateWebUser(WebUser webUser);

    boolean deleteWebUser(int id);


}
