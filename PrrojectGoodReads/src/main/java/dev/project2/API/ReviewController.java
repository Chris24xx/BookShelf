package dev.project2.API;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.project2.Entities.Review;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.Exception.ReviewNotFound;
import dev.project2.Service.Implementation.ReviewImp;
import io.javalin.http.Handler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;

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
            Gson gson = new Gson();
            String newReview = gson.toJson(review);
            context.result(newReview);
            context.status(201);
        } catch (ReviewNotFound e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getAllReview = context -> {
        List<Review> reviewList = this.reviewImp.getAllReviewsService();
        Gson gson = new Gson();
        String list = gson.toJson(reviewList);
        context.result(list);
        context.status(200);
    };

    public Handler getPendingReview = context -> {
        try{
            List<Review> pendingReviewList = this.reviewImp.getPendingReviewsService();
            Gson gson = new Gson();
            String list = gson.toJson(pendingReviewList);
            context.result(list);
            context.status(201);
        } catch (ListCanNotBeGenerated e) {
            context.result(e.getMessage());
            context.status(404);
        }
    };

    public Handler getPastReviews = context -> {
        try{
            List<Review> pendingReviewList = this.reviewImp.notNullReviewsService();
            Gson gson = new Gson();
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
        context.status(201);
    };

    public Handler updateReview = context -> {
        int reviewId = Integer.parseInt(context.pathParam("reviewId"));
        Gson gson = new Gson();
        Boolean status = gson.fromJson(context.body(),Boolean.class);
        boolean result = this.reviewImp.updateReviewService(reviewId,status);
        String newResult = gson.toJson(result);
        context.result(newResult);
        context.status(201);
    };

}
