package dev.project2.Entities;


import java.time.*;
import java.time.format.DateTimeFormatter;

import java.util.Objects;

public class Review {
    private int reviewId;
    private Boolean status;
    private String createdAt;
    private int userId;
    private int rating;
    private String userReview;
    private int mediaId;


    public Review(){}

    public Review(Boolean status, String userReview){
        this.status = status;
        this.userReview = userReview;
    }

    public Review(int reviewId, Boolean status,String createdAt, int mediaId, int userId, int rating, String userReview) {
        this.reviewId = reviewId;
        this.status = status;
        this.createdAt = LocalDateTime.now().toString();
        this.mediaId = mediaId;
        this.userId = userId;
        this.rating = rating;
        this.userReview = userReview;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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
        return userReview;
    }

    public void setReview(String userReview) {
        this.userReview = userReview;
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
                ", review='" + userReview + '\'' +
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
