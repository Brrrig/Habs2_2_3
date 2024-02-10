package mvc_ent2_2_3.service;

import mvc_ent2_2_3.dao.UserDao;
import mvc_ent2_2_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User userById(long id) {
        return userDao.userById(id);
    }
}
