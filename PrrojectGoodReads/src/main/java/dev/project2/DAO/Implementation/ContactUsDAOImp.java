package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.Entities.ContactUs;
import dev.project2.Exception.ContactUsNotFound;
import dev.project2.Util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactUsDAOImp implements ContactUsAbstract {
    @Override
    public ContactUs createContact(ContactUs contactUs) {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "insert into project2.contact_us values(default,?,?,?,false)";
            PreparedStatement state = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            state.setInt(1,contactUs.getContactId());
            state.setString(1,contactUs.getEmail());
            state.setString(2,contactUs.getFullName());
            state.setString(3,contactUs.getIssueMessage());
            state.execute();
            ResultSet resultSet = state.getGeneratedKeys();
            resultSet.next();
            contactUs.setContactId(resultSet.getInt(1));
            contactUs.setStatus(resultSet.getBoolean(5));
            return contactUs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ContactUs getContactUsById(int contactId) {
        try (Connection conn = DBConn.createConnection()) {
            String sql = "select * from project2.contact_us where contact_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, contactId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ContactUs contactUs = new ContactUs(
                        resultSet.getInt("contact_id"),
                        resultSet.getBoolean("status"),
                        resultSet.getString("full_name"),
                        resultSet.getString("issue_message"),
                        resultSet.getString("email")
                );
                return contactUs;
            } else {
                throw new ContactUsNotFound("Contact request not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

        @Override
    public List<ContactUs> getAllContactRequests() {
            try (Connection conn = DBConn.createConnection()) {
                String sql = "select * from project2.contact_us";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                List<ContactUs> contactUsList = new ArrayList<>();
                while(resultSet.next()){
                    ContactUs contactUs = new ContactUs(
                            resultSet.getInt("contact_id"),
                            resultSet.getBoolean("status"),
                            resultSet.getString("full_name"),
                            resultSet.getString("issue_message"),
                            resultSet.getString("email")
                            );
                    contactUsList.add(contactUs);
                }

        return contactUsList;
    } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }

            @Override
    public List<ContactUs> getPendingContactRequests() {
                try (Connection conn = DBConn.createConnection()) {
                    String sql = "select * from project2.contact_us where status = false";
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    List<ContactUs> contactUsList = new ArrayList<>();
                    while(resultSet.next()){
                        ContactUs contactUs = new ContactUs(
                                resultSet.getInt("contact_id"),
                                resultSet.getBoolean("status"),
                                resultSet.getString("full_name"),
                                resultSet.getString("issue_message"),
                                resultSet.getString("email")
                        );
                        contactUsList.add(contactUs);
                    }

                    return contactUsList;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }


    @Override
    public List<ContactUs> getCompletedContactRequests() {
        try (Connection conn = DBConn.createConnection()) {
            String sql = "select * from project2.contact_us where status = true";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<ContactUs> contactUsList = new ArrayList<>();
            while(resultSet.next()){
                ContactUs contactUs = new ContactUs(
                        resultSet.getInt("contact_id"),
                        resultSet.getBoolean("status"),
                        resultSet.getString("full_name"),
                        resultSet.getString("issue_message"),
                        resultSet.getString("email")
                );
                contactUsList.add(contactUs);
            }

            return contactUsList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateContactRequestById(int contactId) {
        try(Connection connection = DBConn.createConnection()) {
            String sql = "update project2.contact_us set status = true where contact_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contactId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteContactRequestById(int contactId) {
        try(Connection connection = DBConn.createConnection()) {
            String sql;
            sql = "delete from project2.contact_us where contact_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,contactId);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
