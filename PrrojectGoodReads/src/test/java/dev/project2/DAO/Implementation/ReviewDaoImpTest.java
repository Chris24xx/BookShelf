package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.ReviewAbstract;
import dev.project2.Entities.Review;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static dev.project2.Entities.Review.*;
import static org.testng.Assert.*;

public class ReviewDaoImpTest {
    ReviewAbstract dao = new ReviewDaoImp();



    @Test
    public void testCreateReview() {
        Review review = new Review(1,null, Instant.now(),2,1,5,"test");
        Review returnedReview = dao.createReview(review);
        Assert.assertTrue(returnedReview.getReviewId() != 0);
    }

    @Test
    public void testGetReview() {
        Review review = dao.getReview(7,1);
        Assert.assertEquals(review.getRating(),5);
    }

    @Test
    public void testGetAllReviews() {
        List<Review> reviews = dao.getAllReviews();
        Assert.assertTrue(reviews.size() >= 2);

    }

    @Test
    public void testDeleteReview() {
        boolean result = dao.deleteReview(8);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateReview() {
        Review review = new Review(9,true,Instant.now(),2,1,5,"test");
        Review updateReview = dao.updateReview(review);
        Assert.assertTrue(updateReview.isStatus());
    }

    @Test
    public void testGetPendingReviews() {
        List<Review> reviews = dao.getPendingReviews();
        for(Review r: reviews){
            System.out.println(r);
        }
        Assert.assertTrue(reviews.size() >= 2);
    }

    @Test
    public void testNotNullReviews() {
        List<Review> reviews = dao.notNullReviews();
        Assert.assertTrue(reviews.size() >= 2);
    }
}