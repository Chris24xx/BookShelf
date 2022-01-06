package dev.project2.controllers;

import com.google.gson.Gson;
import dev.project2.Entities.ContactUs;
import dev.project2.Exception.ContactUsNotFound;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.Service.Implementation.ContactUsServiceImp;
import io.javalin.http.Handler;

import java.util.List;

public class ContactUsController {
    ContactUsServiceImp contactService;

    public ContactUsController(ContactUsServiceImp contactService) {
        this.contactService = contactService;
    }

    public Handler createContactRequest = context -> {
        Gson gson = new Gson();
        ContactUs newContactUs = gson.fromJson(context.body(), ContactUs.class);
        ContactUs contactus = this.contactService.createContact(newContactUs);
        String createdContactRequest = gson.toJson(contactus);
        context.result(createdContactRequest);
        context.status(201);

    };

    public Handler getContactRequestById = context -> {
        int contactId = Integer.parseInt(context.pathParam("contactId"));
        try{
            ContactUs contact = this.contactService.getContactUsById(contactId);
            Gson gson = new Gson();
            String newContactRequest = gson.toJson(contact);
            context.result(newContactRequest);
            context.status(201);
        } catch (ContactUsNotFound e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getCompletedContactRequests = context -> {
       try {
           List<ContactUs> completedContactRequestList = this.contactService.getCompletedContactRequests();
           Gson gson = new Gson();
           String completedList = gson.toJson(completedContactRequestList);
           context.result(completedList);
           context.status(200);
       } catch (ListCanNotBeGenerated e){
           context.result("cannot get all completed requests");
           context.status(404);
       }

    };

    public Handler getPendingContactRequests = context -> {
        try {
            List<ContactUs> pendingContactRequestList = this.contactService.getPendingContactRequests();
            Gson gson = new Gson();
            String pendingList = gson.toJson(pendingContactRequestList);
            context.result(pendingList);
            context.status(200);
        } catch (ListCanNotBeGenerated e){
            context.result("No Pending Requests");
            context.status(404);
        }
    };

    public Handler getAllContactRequests = context -> {
        try {
            List<ContactUs> allContactRequestList = this.contactService.getAllContactRequests();
            Gson gson = new Gson();
            String allList = gson.toJson(allContactRequestList);
            context.result(allList);
            context.status(200);
        } catch (ListCanNotBeGenerated e){
            context.result("Cannot get all requests");
            context.status(404);
        }
    };

    public Handler updateContactRequestById = context -> {
        int contactId = Integer.parseInt(context.pathParam("contactId"));
        Gson gson =  new Gson();
        boolean result = this.contactService.updateContactRequestById(contactId);
        String newResult = gson.toJson(result);
        context.result(newResult);
        context.status(201);
    };

    public Handler deleteContactRequestById = context -> {
        int contactId = Integer.parseInt(context.pathParam("contactId"));
        Gson gson =  new Gson();
        boolean result = this.contactService.deleteContactRequestById(contactId);
        String newResult = gson.toJson(result);
        context.result(newResult);
        context.status(201);
    };




}
