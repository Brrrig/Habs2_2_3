package mvc_ent2_2_3.dao;

import mvc_ent2_2_3.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> listUsers();

    void remove(long id);

    void update(User user);

    User userById(long id);
}
