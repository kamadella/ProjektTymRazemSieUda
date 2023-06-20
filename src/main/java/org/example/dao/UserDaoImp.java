package org.example.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.models.User;

import java.util.List;
import java.util.Optional;
@Stateless
public class UserDaoImp {
    @PersistenceContext(unitName = "PU")
    private EntityManager em;
    public User saveOrUpdate(User user) {
        if (user.getId() == null)
            em.persist(user);
        else {
            user = em.merge(user);
        }
        return user;
    }

    public void remove(Long id) {
        em.remove(em.getReference(User.class, id));
    }

    public Optional<User> findById(Long id) {
        User b = em.find(User.class,id);
        return Optional.ofNullable(b);
    }

    public List<User> findAll() {
        TypedQuery<User> q = em.createNamedQuery("User.findAll", User.class);
        return q.getResultList();
    }
}
