package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> allUsers();
    User update(User user);
    void deleteUser(int id);
    User showUserById(int id);
}
