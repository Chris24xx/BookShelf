package dev.project2.DAO.Implementation;
import dev.project2.DAO.Abstract.*;
import dev.project2.Entities.Review;
import dev.project2.dbcon.DBConn;

import java.sql.SQLException;
import java.sql.*;
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
            state.setTimestamp(1, Timestamp.from(review.getCreatedAt()));
            state.setInt(2,review.getMediaId());
            state.setInt(3,review.getUserId());
            state.setInt(4,review.getRating());
            state.setString(5,review.getUserReview());
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
                review.setCreatedAt(resultSet.getTimestamp("created_at").toInstant());
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
    public List<Review> getAllReviews() {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "select * from project2.review";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Review> reviewList = new ArrayList<>();
            while(resultSet.next()){
                Review review = new Review(
                        resultSet.getInt(1),
                        resultSet.getBoolean(2),
                        resultSet.getTimestamp(3).toInstant(),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getString(7)
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
    public Review updateReview(Review review) {
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql ="update project2.review set status = ? where review_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1,review.isStatus() );
            preparedStatement.setInt(2, review.getReviewId());
            preparedStatement.execute();
            return review;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Review> getPendingReviews() {
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql = "select status, user_review from project2.review where status is null";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Review> reviewList = new ArrayList<>();
            while (resultSet.next()){
                Review review = new Review(
                        resultSet.getObject("status", Boolean.class),
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
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql = "select status, user_review from project2.review where status is not null";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Review> reviewList= new ArrayList<>();
            while (resultSet.next()){
                Review review = new Review(
                        resultSet.getBoolean("status"),
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
