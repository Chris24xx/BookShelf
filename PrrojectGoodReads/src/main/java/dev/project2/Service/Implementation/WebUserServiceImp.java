package dev.project2.Service.Implementation;

import dev.project2.DAO.Abstract.WebUserDAO;
import dev.project2.Entities.WebUser;
import dev.project2.Exception.WebUserNotFound;
import dev.project2.Service.Abstract.WebUserServiceAbs;

import java.util.List;

public class WebUserServiceImp implements WebUserServiceAbs {
    WebUserDAO webUserDAO;

    public WebUserServiceImp(WebUserDAO webUserDAO){
        this.webUserDAO = webUserDAO;
    }

    @Override
    public WebUser makeModerator(Boolean modCheck, int id) {
        WebUser currentUser = getWebUserByIdService(id);
        WebUser modUpdate = new WebUser(
                currentUser.getUserId(),
                currentUser.getFirstName(),
                currentUser.getLastName(),
                currentUser.getUserEmail(),
                currentUser.getPassword(),
                modCheck
        );
        WebUser updateUser = webUserDAO.updateWebUser(modUpdate);
        return updateUser;
    }

    @Override
    public WebUser getWebUserByIdService(int id) {
        try{
            WebUser webUser = this.webUserDAO.getWebUserById(id);
            return webUser;
        }catch (Exception e){
            throw new WebUserNotFound("WebUser not found");
        }
    }

    @Override
    public List<WebUser> getAllWebUsers() {
        return this.webUserDAO.getAllWebUsers();
    }

    @Override
    public WebUser createWebUser(WebUser webUser) {
        return this.webUserDAO.createWebUser(webUser);
    }

    @Override
    public WebUser updateWebUser(WebUser webUser) {
        return this.webUserDAO.updateWebUser(webUser);
    }

    @Override
    public boolean deleteWebUser(int id) {
        return this.webUserDAO.deleteWebUser(id);
    }
}
