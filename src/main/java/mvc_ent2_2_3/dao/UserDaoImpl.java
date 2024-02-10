package mvc_ent2_2_3.dao;

import mvc_ent2_2_3.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public void remove(long id) {
        entityManager.remove(userById(id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User userById(long id) {
        return entityManager.find(User.class, id);
    }
}
