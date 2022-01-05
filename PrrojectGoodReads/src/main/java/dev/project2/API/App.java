package dev.project2.API;

import dev.project2.DAO.Implementation.ReviewDaoImp;
import dev.project2.Service.Implementation.ReviewImp;
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

        app.post("/review", reviewController.createReview);

        app.get("/review/{reviewId}/{userId}", reviewController.getReview);

        app.get("/review/all", reviewController.getAllReview);

        app.get("/review/pending", reviewController.getPendingReview);

        app.get("/review/past", reviewController.getPastReviews);

        app.patch("/review/update/{reviewId}",reviewController.updateReview);

        app.delete("/review/delete/{reviewId}", reviewController.deleteReview);

        app.start();
    }
}
