package dev.project2.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.project2.Entities.Review;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.Exception.ReviewNotFound;
import dev.project2.Service.Implementation.ReviewImp;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

public class ReviewController {
    ReviewImp reviewImp;

    public ReviewController(ReviewImp reviewImp){
        this.reviewImp = reviewImp;
    }

    public Handler createReview = context -> {
        Gson gson = new Gson();
        Review newReview = gson.fromJson(context.body(), Review.class);
        Review review = this.reviewImp.createReviewService(newReview);
        String createdReview = gson.toJson(review);
        context.result(createdReview);
        context.status(201);
    };

    public Handler getReview = context -> {
        int reviewId = Integer.parseInt(context.pathParam("reviewId"));
        int userId = Integer.parseInt(context.pathParam("userId"));
        try{
            Review review = this.reviewImp.getReviewService(reviewId,userId);
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.setPrettyPrinting().create();
            String newReview = gson.toJson(review);
            context.result(newReview);
            context.status(201);
        } catch (ReviewNotFound e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getAllReview = context -> {
        int reviewId = Integer.parseInt(context.pathParam("userId"));
        List<Review> reviewList = this.reviewImp.getAllReviewsService(reviewId);
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.setPrettyPrinting().create();
        String list = gson.toJson(reviewList);
        context.result(list);
        context.status(200);
    };

    public Handler getPendingReview = context -> {
        try{
            List<Review> pendingReviewList = this.reviewImp.getPendingReviewsService();
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.setPrettyPrinting().create();
            String list = gson.toJson(pendingReviewList);
            context.result(list);
            context.status(200);
        } catch (ListCanNotBeGenerated e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getPastReviews = context -> {
        try{
            List<Review> pendingReviewList = this.reviewImp.notNullReviewsService();
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.setPrettyPrinting().create();
            String list = gson.toJson(pendingReviewList);
            context.result(list);
            context.status(201);
        } catch (ListCanNotBeGenerated e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler deleteReview = context -> {
        int reviewId = Integer.parseInt(context.pathParam("reviewId"));
        boolean result = this.reviewImp.deleteReviewService(reviewId);
        Gson gson = new Gson();
        String newResult = gson.toJson(result);
        context.result(newResult);
        context.status(200);
    };

    public Handler updateReview = context -> {
        int reviewId = Integer.parseInt(context.pathParam("reviewId"));
        Gson gson = new Gson();
        Map<String,Boolean> status = gson.fromJson(context.body(), Map.class );
        if(status.get("status")){
            boolean result = this.reviewImp.updateReviewService(reviewId,true);
            gson.toJson(result);
            context.result("success");
            context.status(201);

        }else{
            boolean result = this.reviewImp.updateReviewService(reviewId,false);
            gson.toJson(result);
            context.result("success");
            context.status(201);
        }




    };

}
