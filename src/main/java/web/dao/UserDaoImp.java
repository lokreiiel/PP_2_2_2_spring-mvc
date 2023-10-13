package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
       entityManager.persist(user);
    }

    @Override
//    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null){
            entityManager.remove(user);
        }
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
