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
        }catch (NullPointerException e){
            throw new WebUserNotFound("User not found");
        }
    }

    @Override
    public List<WebUser> getAllWebUsers() {
        return this.webUserDAO.getAllWebUsers();
    }

    @Override
    public WebUser createWebUser(WebUser webUser, String email) {

        WebUser userByEmail = getWebUserByEmailService(email);

        if(userByEmail == null){
            return this.webUserDAO.createWebUser(webUser);
        }
        else{
            throw new WebUserNotFound("Email is already in use");
        }
    }

    @Override
    public WebUser updateWebUser(WebUser webUser) {
        return this.webUserDAO.updateWebUser(webUser);
    }

    @Override
    public boolean deleteWebUser(int id) {
        return this.webUserDAO.deleteWebUser(id);
    }

    @Override
    public WebUser getWebUserByEmailService(String email) {
        try{
            WebUser webUser = this.webUserDAO.getWebUserByEmail(email);
            return webUser;
        }catch (NullPointerException e){
            throw new WebUserNotFound("Email not found");
        }
    }

    @Override
    public WebUser webUserLoginCheck(String email, String password) {
        try{
            WebUser currentWebUser = this.webUserDAO.getWebUserByEmail(email);
            if (currentWebUser.getUserEmail().equals(email))
                if (currentWebUser.getPassword().equals(password))
                    return currentWebUser;
            throw new WebUserNotFound("Incorrect email or Password");
        }catch (NullPointerException e) {
            throw new WebUserNotFound("Incorrect email or Password");
        }
    }
}
