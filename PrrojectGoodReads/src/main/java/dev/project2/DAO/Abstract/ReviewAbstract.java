package dev.project2.DAO.Abstract;

import dev.project2.Entities.Review;

import java.util.List;

public interface ReviewAbstract {
    Review createReview(Review review);

    Review getReview(int reviewId,int userID);

    List<Review> getAllReviews(int reviewId, int mediaId);

    boolean deleteReview(int reviewId);

    boolean updateReview(int reviewId, Boolean status);

    List<Review> getPendingReviews();

    List<Review> notNullReviews();
}
