package dev.project2.DAO.Implementation;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.Entities.Media;
import dev.project2.dbcon.DBConn;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Media table order: media_id, title, creator, synopsis, media_type, genre, status, user_id


public class MediaDAOImp implements MediaDAO {

    @Override
    public Media createNewMedia(Media media) {
        try (Connection connection = DBConn.createConnection()){
            String sql = "insert into media values(default, ?, ?, ?, ?, ?, default, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, media.getTitle());
            preparedStatement.setString(2, media.getCreator());
            preparedStatement.setString(3, media.getSynopsis());
            preparedStatement.setString(4, media.getMediaType());
            preparedStatement.setString(5, media.getGenre());
            preparedStatement.setInt(6, media.getUserId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            media.setMediaId(resultSet.getInt("media_id"));
            return media;
        } catch (SQLException q) {
            q.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Media> getAllMedia() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Media> getAllBooks() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where media_type = 'Book'";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Media> getAllMovies() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where media_type = 'Movie'";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Media> getAllGames() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where media_type = 'Game'";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }


    // Need to change to include prepared statement.
    @Override
    public List<Media> getMediaByTitle() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where title = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }


    // Remake to include prepared statement.
    @Override
    public List<Media> getAllMediaPerUser() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where user_id = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Media> getPendingMedia() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from media where status = false";
            Statement statement = connection.createStatement();
            ResultSet resultSet  = statement.executeQuery(sql);
            List<Media> allMedia = new ArrayList<>();
            while(resultSet.next()){
                Media media = new Media(
                        resultSet.getInt("media_id"),
                        resultSet.getString("title"),
                        resultSet.getString("creator"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("media_type"),
                        resultSet.getString("genre"),
                        resultSet.getBoolean("status"),
                        resultSet.getInt("user_id")
                );
                allMedia.add(media);
            }
            return allMedia;
        } catch (SQLException q){
            q.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean approveDenyMedia() {
        return false;
    }
}
