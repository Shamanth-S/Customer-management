package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.javaguides.usermanagement.model.User;

public class UserDAO {

    private String JDBC_URL = "jdbc:mysql://localhost:3306/login_new";
    private String JDBC_USERNAME = "root";
    private String JDBC_PASSWORD = "root1234";

    private static final String INSERT_USERS = "INSERT INTO login_new.cust"
            + "(id, firstname, lastname, address, city, state, email, phone) VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USERS = "SELECT id, firstname, lastname, address, city, state, email, phone FROM login_new.cust where id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM login_new.cust;";
    private static final String DELETE_USERS = "DELETE FROM login_new.cust where id = ?;";
    private static final String UPDATE_USERS = "UPDATE login_new.cust set firstname = ?, lastname = ?, address = ?, city = ?, state = ?, email = ?, phone = ? WHERE id = ?;";

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to establish a database connection.", e);
        }
        return conn;
    }

    // Create or insert user
    public void insertUser(User user) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_USERS)) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getState());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while inserting a user.", e);
        }
    }

    // Update user
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_USERS)) {
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getCity());
            ps.setString(5, user.getState());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPhone());
            ps.setString(8, user.getId());
            rowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating a user.", e);
        }
        return rowUpdated;
    }

    // Select user by id
    public User selectUser(String id) {
        User user = null;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USERS)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                user = new User(id, firstname, lastname, address, city, state, email, phone);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while selecting a user.", e);
        }
        return user;
    }

    // Select users
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                users.add(new User(id, firstname, lastname, address, city, state, email, phone));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while selecting all users.", e);
        }
        return users;
    }

    // Delete user
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_USERS)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting a user.", e);
        }
        return rowDeleted;
    }
}
