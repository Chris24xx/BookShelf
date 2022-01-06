package dev.project2.Service.Implementation;

import dev.project2.DAO.Abstract.ReviewAbstract;
import dev.project2.DAO.Implementation.ReviewDaoImp;
import dev.project2.Entities.Review;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.Exception.ReviewNotFound;
import dev.project2.Service.Abstract.ReviewAbs;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class ReviewImpTest {
    static ReviewDaoImp reviewDao;
    static ReviewImp reviewImp;

    @BeforeClass
    public void setup() {
        reviewDao = Mockito.mock(ReviewDaoImp.class);
        reviewImp = new ReviewImp(reviewDao);
    }



    @Test (expectedExceptions = ReviewNotFound.class, expectedExceptionsMessageRegExp = "Review not Found!")
    void getReviewFail(){
        Mockito.when(reviewDao.getReview(100,100)).thenThrow(new ReviewNotFound("Review not Found!"));
        Review review = reviewImp.getReviewService(100,100);
    }

    @Test (expectedExceptions = ListCanNotBeGenerated.class, expectedExceptionsMessageRegExp = "No list can be generated")
    public void testGetPendingReviews() {
        Mockito.when(reviewDao.getPendingReviews()).thenThrow(new ListCanNotBeGenerated("No list can be generated"));
        List<Review> reviews = reviewImp.getPendingReviewsService();
    }

    @Test (expectedExceptions = ListCanNotBeGenerated.class, expectedExceptionsMessageRegExp = "No list can be generated")
    public void testNotNullReviews() {
        Mockito.when(reviewDao.notNullReviews()).thenThrow(new ListCanNotBeGenerated("No list can be generated"));
        List<Review> reviewList = reviewImp.notNullReviewsService();
    }


}