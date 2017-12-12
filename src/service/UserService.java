package service;

import dao.UserDao;
import domain.User;
import utils.ErrorCode;

public class UserService {
    public ErrorCode registUser(User user) {
        ErrorCode errorCode = new UserDao().insertUser(user);
        return errorCode;
    }

    public User loginUser(String name, String password) {
        User user = new UserDao().findUserByNameAndPassword(name, password);
        return user;
    }
}
