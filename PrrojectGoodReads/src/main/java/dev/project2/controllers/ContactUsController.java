package dev.project2.controllers;

import com.google.gson.Gson;
import dev.project2.Entities.ContactUs;
import dev.project2.Service.Implementation.ContactUsServiceImp;
import io.javalin.http.Handler;

public class ContactUsController {
    ContactUsServiceImp contactService;

    public ContactUsController(ContactUsServiceImp contactService) {
        this.contactService = contactService;
    }

    public Handler createContactRequest = ctx -> {
        Gson gson = new Gson();
        ContactUs newContactUs = gson.fromJson(ctx.body(), )

    };

    public Handler getPlayerById = ctx -> {

    };

    public Handler getAllContactRequests = ctx -> {

    };

    public Handler getPendingContactRequests = ctx -> {

    };

    public Handler getCompletedContactRequests = ctx -> {

    };


}
