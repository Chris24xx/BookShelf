package dev.project2.controllers;

import com.google.gson.Gson;
import dev.project2.Entities.WebUser;
import dev.project2.Exception.WebUserNotFound;
import dev.project2.Service.Implementation.WebUserServiceImp;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

public class WebUserController {
    WebUserServiceImp webUserServiceImp;

    public WebUserController(WebUserServiceImp webUserServiceImp){
        this.webUserServiceImp = webUserServiceImp;
    }

    public Handler createWebUser = context -> {
        Gson gson = new Gson();
        try{
            WebUser newWebUser = gson.fromJson(context.body(), WebUser.class);
            String newEmail = newWebUser.getUserEmail();
            WebUser webUser = this.webUserServiceImp.createWebUser(newWebUser, newEmail);
            String createdWebUser = gson.toJson(webUser);
            context.result(createdWebUser);
            context.status(201);
        } catch (WebUserNotFound e){
            context.result(gson.toJson(e.getMessage()));
            context.status(404);
        }

    };

    public Handler getWebUserById = context -> {
        Gson gson = new Gson();
        int webUserId = Integer.parseInt(context.pathParam("userId"));
        try{
            WebUser webUser = this.webUserServiceImp.getWebUserByIdService(webUserId);
            String newWebUser = gson.toJson(webUser);
            context.result(newWebUser);
            context.status(201);
        } catch (WebUserNotFound e) {
            context.result(gson.toJson(e.getMessage()));
            context.status(404);
        }
    };

    public Handler getAllWebUsers = context -> {
        Gson gson = new Gson();
        List<WebUser> webUserList = this.webUserServiceImp.getAllWebUsers();
        String list = gson.toJson(webUserList);
        context.result(list);
        context.status(200);
    };

    public Handler deleteWebUser = context -> {
        Gson gson = new Gson();
        int webUserId = Integer.parseInt(context.pathParam("userId"));
        boolean result = this.webUserServiceImp.deleteWebUser(webUserId);
        String resultBool = gson.toJson(result);
        context.result(resultBool);
        context.status(201);
    };

    public Handler moderatorStatus = context -> {
        int webUserId = Integer.parseInt(context.pathParam("userId"));
        Gson gson = new Gson();
        Map<String, Boolean> modBool = gson.fromJson(context.body(), Map.class);
        boolean status = modBool.get("value");
        WebUser updatedWebUser = this.webUserServiceImp.makeModerator(status,webUserId);
        String updatedModUser = gson.toJson(updatedWebUser);
        context.result(updatedModUser);
        context.status(201);
    };

    public Handler webUserLoginStatus = context -> {
        Gson gson = new Gson();
        try{
            Map<String, String> userLoginInputs = gson.fromJson(context.body(), Map.class);
            String userEmail = userLoginInputs.get("userEmail");
            String password = userLoginInputs.get("password");
            WebUser webUser = this.webUserServiceImp.webUserLoginCheck(userEmail, password);
            String newWebUser = gson.toJson(webUser);
            context.result(newWebUser);
            context.status(201);
        } catch (WebUserNotFound e) {
            context.result(gson.toJson(e.getMessage()));
            context.status(404);
        }
    };
}
