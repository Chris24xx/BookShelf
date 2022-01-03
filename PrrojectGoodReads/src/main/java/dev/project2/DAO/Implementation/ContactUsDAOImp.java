package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.ContactUsAbstract;
import dev.project2.Entities.ContactUs;
import dev.project2.dbcon.DBConn;

import java.sql.*;
import java.util.List;

public class ContactUsDAOImp implements ContactUsAbstract {
    @Override
    public ContactUs createContact(ContactUs contactUs) {
        try(Connection conn = DBConn.createConnection()) {
            String sql;
            sql = "insert into project2.contactUs values(default, null, ?,?)";
            PreparedStatement state = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            state.setInt(1,contactUs.getContactId());
            state.setString(2,contactUs.getEmail());
            state.setString(3,contactUs.getFullName());
            state.setString(4,contactUs.getIssueMessage());
            state.execute();
            ResultSet resultSet = state.getGeneratedKeys();
            resultSet.next();
            return contactUs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ContactUs getContactUsById(int contactId) {
        return null;
    }

    @Override
    public List<ContactUs> getAllContactRequests() {
        return null;
    }

    @Override
    public List<ContactUs> getPendingContactRequests() {
        return null;
    }

    @Override
    public List<ContactUs> getCompletedContactRequests() {
        return null;
    }

    @Override
    public ContactUs updateContactRequestById(int contactId) {
        return null;
    }

    @Override
    public boolean deleteContactRequestById(int contactId) {
        return false;
    }
}
