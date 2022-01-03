package dev.project2.DAO.Abstract;

import dev.project2.Entities.Review;

import java.util.List;

public interface ReviewAbstract {
    Review createReview(Review review);

    Review getReview(int reviewId,int userID);

    List<Review> getAllReviews();

    boolean deleteReview(int reviewId);

    Review updateReview(Review review);

    List<Review> getPendingReviews();

    List<Review> notNullReviews();
}
