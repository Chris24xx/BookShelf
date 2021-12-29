package dev.project2.Entities;

import java.util.Objects;

public class Review {
    private int reviewId;
    private boolean status;
    private String createdAt;
    private int mediaId;
    private int userId;

    public Review(){}

    public Review(int reviewId, boolean status, String createdAt, int mediaId, int userId) {
        this.reviewId = reviewId;
        this.status = status;
        this.createdAt = createdAt;
        this.mediaId = mediaId;
        this.userId = userId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", status=" + status +
                ", createdAt='" + createdAt + '\'' +
                ", mediaId=" + mediaId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getReviewId() == review.getReviewId() && isStatus() == review.isStatus() && getMediaId() == review.getMediaId() && getUserId() == review.getUserId() && getCreatedAt().equals(review.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), isStatus(), getCreatedAt(), getMediaId(), getUserId());
    }
}
