package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.WebUserDAO;
import dev.project2.Entities.WebUser;
import dev.project2.dbcon.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WebUserDAOImp implements WebUserDAO {

    @Override
    public WebUser getWebUserById(int id) {
        try(Connection connection = DBConn.createConnection()){
            String sql = "select * from project2.web_user where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                WebUser webUser = new WebUser(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("user_password"),
                        resultSet.getBoolean("enabled_moderator")
                );
                return webUser;
            }
            else{
                throw new RuntimeException("WebUser not found");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<WebUser> getAllWebUsers() {
        try (Connection connection = DBConn.createConnection()){
            String sql = "select * from project2.web_user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<WebUser> webUsers = new ArrayList<>();
            while(resultSet.next()){
                WebUser webUser= new WebUser(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("user_password"),
                        resultSet.getBoolean("enabled_moderator")
                );
                webUsers.add(webUser);
            }
            return webUsers;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WebUser createWebUser(WebUser user) {
        try (Connection connection = DBConn.createConnection()){
            String sql = "insert into project2.web_user values(default, ?, ?, ?, ?, false)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            user.setUserId(resultSet.getInt("user_id"));
            return user;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WebUser updateWebUser(WebUser user) {
        try (Connection connection = DBConn.createConnection()){
            String sql = "update project2.web_user set first_name = ?, last_name = ?, email = ?, user_password = ?, enabled_moderator = ? where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.isModerator());
            preparedStatement.setInt(6, user.getUserId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            user.setUserId(resultSet.getInt("user_id"));
            return user;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteWebUser(int id) {
        try(Connection connection = DBConn.createConnection()){
        String sql = "delete from project2.web_user where user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return true;
    } catch (SQLException e){
        e.printStackTrace();
        return false;
    }
    }
}
