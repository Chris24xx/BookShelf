package dev.project2.API;

import dev.project2.DAO.Implementation.ContactUsDAOImp;
import dev.project2.DAO.Implementation.ReviewDaoImp;
import dev.project2.Service.Implementation.ContactUsServiceImp;
import dev.project2.Service.Implementation.ReviewImp;
import dev.project2.controllers.ContactUsController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        ReviewDaoImp reviewDaoImp = new ReviewDaoImp();
        ReviewImp reviewImp = new ReviewImp(reviewDaoImp);
        ReviewController reviewController = new ReviewController(reviewImp);
        ContactUsDAOImp contactDaoImp = new ContactUsDAOImp();
        ContactUsServiceImp contactService = new ContactUsServiceImp(contactDaoImp);
        ContactUsController contactController = new ContactUsController(contactService);

        app.post("/review", reviewController.createReview);

        app.get("/review/{reviewId}/{userId}", reviewController.getReview);

        app.get("/review/all/{reviewId}", reviewController.getAllReview);

        app.get("/review/pending", reviewController.getPendingReview);

        app.get("/review/past", reviewController.getPastReviews);

        app.patch("/review/update/{reviewId}",reviewController.updateReview);

        app.delete("/review/delete/{reviewId}", reviewController.deleteReview);

        app.post("/contact", contactController.createContactRequest);

        app.get("/contact/{contactId}", contactController.getContactRequestById);

        app.get("/contactRequests/all", contactController.getAllContactRequests);

        app.get("/contactRequests/pending", contactController.getPendingContactRequests);

        app.get("/contactRequests/completed", contactController.getCompletedContactRequests);

        app.patch("/updateContactRequestStatus/{contactId}", contactController.updateContactRequestById);

        app.delete("/deleteContactRequest/{contactId}", contactController.deleteContactRequestById);

        app.start();
    }
}
