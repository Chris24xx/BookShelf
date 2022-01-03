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
}