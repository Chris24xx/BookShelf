package dev.project2.Service.Abstract;

import dev.project2.Entities.Review;

import java.util.List;

public interface ReviewAbs {
    Review createReviewService(Review review);

    Review getReviewService(int reviewId,int userID);

    List<Review> getAllReviewsService(int reviewId);

    boolean deleteReviewService(int reviewId);

    boolean updateReviewService(int reviewId, Boolean status);

    List<Review> getPendingReviewsService();

    List<Review> notNullReviewsService();
}
