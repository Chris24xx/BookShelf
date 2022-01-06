package dev.project2.DAO.Implementation;

//import dev.project2.Website.Abstract.ReviewAbstract;
import dev.project2.DAO.Abstract.ReviewAbstract;
import dev.project2.Entities.Review;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;

public class ReviewDaoImpTest {
    ReviewAbstract dao = new ReviewDaoImp();



    @Test
    public void testCreateReview() {
        Review review = new Review(1,null,"now",1,1,5,"test");
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
        for(Review r: reviews){
            System.out.println(r);
        }
        Assert.assertTrue(reviews.size() >= 2);

    }

    @Test
    public void testDeleteReview() {
        boolean result = dao.deleteReview(8);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateReview() {
        boolean updateReview = dao.updateReview(7, true );
        Assert.assertTrue(updateReview);
    }

    @Test
    public void testGetPendingReviews() {
        List<Review> reviews = dao.getPendingReviews();
        System.out.println(reviews.toString());
        Assert.assertTrue(reviews.size() >= 2);
    }

    @Test
    public void testNotNullReviews() {
        List<Review> reviews = dao.notNullReviews();
        Assert.assertTrue(reviews.size() >= 2);
    }
}