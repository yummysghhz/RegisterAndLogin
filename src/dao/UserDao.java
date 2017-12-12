package dao;

import domain.User;
import utils.DBUtil;
import utils.ErrorCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public ErrorCode insertUser(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ErrorCode errorCode = new ErrorCode();
        if (conn == null) {
            errorCode.setErrorState(ErrorCode.CANNOT_GET_CONNECTION);
            return errorCode;
        }
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO loginss VALUES (?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, 0);
            preparedStatement.executeUpdate();
            return errorCode;
        } catch (Exception e) {
            e.printStackTrace();
            errorCode.setErrorState(ErrorCode.INSERT_ERROR);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                errorCode.setErrorState(ErrorCode.CANNOT_CLOSE_STATEMENT);
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                errorCode.setErrorState(ErrorCode.CANNOT_CLOSE_CONNECTION);
            }
            return errorCode;
        }
    }

    public User findUserByNameAndPassword(String name, String password) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        if (conn == null) {
            return null;
        }
        User user = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM loginss WHERE name =? AND password = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getInt(4));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }

}
