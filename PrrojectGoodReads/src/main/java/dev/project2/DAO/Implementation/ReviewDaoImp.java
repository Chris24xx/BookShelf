package dev.project2.DAO.Implementation;
import dev.project2.DAO.Abstract.*;
import dev.project2.Entities.Review;
import dev.project2.Exception.ListCanNotBeGenerated;
import dev.project2.dbcon.DBConn;

import java.sql.SQLException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.project2.Exception.ReviewNotFound;

public class ReviewDaoImp implements ReviewAbstract  {

    @Override
    public Review createReview(Review review) {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "insert into project2.review values(default,null,?,?,?,?,?)";
            PreparedStatement state = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            state.setString(1, review.getDateAndTime());
            state.setInt(2,review.getUserId());
            state.setInt(3,review.getRating());
            state.setString(4,review.getUserReview());
            state.setInt(5,review.getMediaId());
            state.execute();
            ResultSet resultSet = state.getGeneratedKeys();
            resultSet.next();
            review.setReviewId(resultSet.getInt(1));
            review.setStatus(resultSet.getBoolean(2));
            return review;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Review getReview(int reviewId, int userId) {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "select created_at, rating, user_review from project2.review where review_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,reviewId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Review review = new Review();
                review.setCreatedAt(resultSet.getString("created_at"));
                review.setRating(resultSet.getInt("rating"));
                review.setReview(resultSet.getString("user_review"));
                return review;
            }else {
                throw new ReviewNotFound("No review was found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Review> getAllReviews(int reviewId) {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "select * from project2.review where user_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, reviewId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Review> reviewList = new ArrayList<>();
            while(resultSet.next()){
                Review review = new Review(
                        resultSet.getInt("review_id"),
                        resultSet.getObject("status", Boolean.class),
                        resultSet.getString("created_at"),
                        resultSet.getInt("media_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("user_review")

                );
                reviewList.add(review);


            }
            return reviewList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteReview(int reviewId) {
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql = "delete from project2.review where review_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,reviewId);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateReview(int reviewId,Boolean status) {
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql ="update project2.review set status = ? where review_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, status);
            preparedStatement.setInt(2, reviewId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Review> getPendingReviews() {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "select * from project2.review where status is null";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Review> reviewList = new ArrayList<>();
            while(resultSet.next()){
                Review review = new Review(
                        resultSet.getInt("review_id"),
                        resultSet.getObject("status", Boolean.class),
                        resultSet.getString("created_at"),
                        resultSet.getInt("media_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("user_review")

                );
                reviewList.add(review);


            }
            return reviewList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Review> notNullReviews() {
             try(Connection conn = DBConn.createConnection()) {
                String sql;
                sql = "select * from project2.review where status is not null";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                List<Review> reviewList = new ArrayList<>();
                while(resultSet.next()){
                    Review review = new Review(
                            resultSet.getInt("review_id"),
                            resultSet.getObject("status", Boolean.class),
                            resultSet.getString("created_at"),
                            resultSet.getInt("media_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("rating"),
                            resultSet.getString("user_review")

                    );
                    reviewList.add(review);


                }
                return reviewList;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }
}


