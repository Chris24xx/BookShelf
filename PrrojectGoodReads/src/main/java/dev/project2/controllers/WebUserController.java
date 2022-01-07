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
        WebUser newWebUser = gson.fromJson(context.body(), WebUser.class);
        WebUser webUser = this.webUserServiceImp.createWebUser(newWebUser);
        String createdWebUser = gson.toJson(webUser);
        context.result(createdWebUser);
        context.status(201);
    };

    public Handler getWebUserById = context -> {
        int webUserId = Integer.parseInt(context.pathParam("userId"));
        try{
            WebUser webUser = this.webUserServiceImp.getWebUserByIdService(webUserId);
            Gson gson = new Gson();
            String newWebUser = gson.toJson(webUser);
            context.result(newWebUser);
            context.status(201);
        } catch (WebUserNotFound e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getAllWebUsers = context -> {
        List<WebUser> webUserList = this.webUserServiceImp.getAllWebUsers();
        Gson gson = new Gson();
        String list = gson.toJson(webUserList);
        context.result(list);
        context.status(200);
    };

    public Handler deleteWebUser = context -> {
        int webUserId = Integer.parseInt(context.pathParam("userId"));
        boolean result = this.webUserServiceImp.deleteWebUser(webUserId);
        Gson gson = new Gson();
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
}
