package dev.project2.Service.Implementation;

import dev.project2.DAO.Implementation.ReviewDaoImp;
import dev.project2.Entities.Review;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.Exception.ReviewNotFound;
import dev.project2.Service.Abstract.ReviewAbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReviewImp implements ReviewAbs {
    ReviewDaoImp reviewDao;

    public ReviewImp(ReviewDaoImp reviewDao){
        this.reviewDao = reviewDao;
    }


    @Override
    public Review createReviewService(Review review) {
        return this.reviewDao.createReview(review);
    }

    @Override
    public Review getReviewService(int reviewId, int userID) {
        try{
            Review review = this.reviewDao.getReview(reviewId,userID);
            return review;
        } catch (ReviewNotFound e) {
            throw new ReviewNotFound("Review not Found!");
        }
    }

    @Override
    public List<Review> getAllReviewsService(int reviewId, int mediaId) {return this.reviewDao.getAllReviews(reviewId, mediaId);
    }

    @Override
    public boolean deleteReviewService(int reviewId) {
        return this.reviewDao.deleteReview(reviewId);
    }

    @Override
    public boolean updateReviewService(int reviewId, Boolean status) {
        return this.reviewDao.updateReview(reviewId,status);
    }

    @Override
    public List<Review> getPendingReviewsService() {
        List<Review> reviewList = this.reviewDao.getPendingReviews();
        if(reviewList.size() == 0){
            throw new ListCanNotBeGenerated("No list can be generated");
        }else{
            return this.reviewDao.getPendingReviews();
        }
    }

    @Override
    public List<Review> notNullReviewsService() {
       List<Review> reviewList = this.reviewDao.notNullReviews();
       if(reviewList.size() == 0){
           throw new ListCanNotBeGenerated("no List can be generated");
       }else{
           return this.reviewDao.notNullReviews();
       }
    }
}
