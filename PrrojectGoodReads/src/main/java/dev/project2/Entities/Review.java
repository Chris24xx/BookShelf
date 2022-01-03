package dev.project2.Entities;


import java.time.*;
import java.util.List;
import java.util.Objects;

public class Review {
    private int reviewId;
    private Boolean status;
    private Instant createdAt;
    private int mediaId;
    private int userId;
    private int rating;
    private String user_review;

    public Review(){}

    public Review(Boolean status, String user_review){
        this.status = status;
        this.user_review = user_review;
    }

    public Review(int reviewId, Boolean status, Instant createdAt, int mediaId, int userId, int rating, String user_review) {
        this.reviewId = reviewId;
        this.status = status;
        this.createdAt = createdAt;
        this.mediaId = mediaId;
        this.userId = userId;
        this.rating = rating;
        this.user_review = user_review;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserReview() {
        return user_review;
    }

    public void setReview(String review) {
        this.user_review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", mediaId=" + mediaId +
                ", userId=" + userId +
                ", rating=" + rating +
                ", review='" + user_review + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review1)) return false;
        return getReviewId() == review1.getReviewId() && isStatus() == review1.isStatus() && getMediaId() == review1.getMediaId() && getUserId() == review1.getUserId() && getRating() == review1.getRating() && getCreatedAt().equals(review1.getCreatedAt()) && getUserReview().equals(review1.getUserReview());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), isStatus(), getCreatedAt(), getMediaId(), getUserId(), getRating(), getUserReview());
    }
}
