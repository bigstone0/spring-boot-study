package com.example.musiclist.domain;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Modifying
    @Transactional
    @Query(value="UPDATE User l SET l.user_name= :name WHERE l.user_id=:id",nativeQuery = true)
    void update(@Param("name") String name,@Param("id") long id);
}


//@RequiredArgsConstructor
//public class UserRepository {
//    private final EntityManager em;
//
//    public void save(User user) {
//        em.persist(user);
//    }
//
//    public User findOne(int id) {
//        return em.find(User.class, id);
//    }
//
//    public List<User> findAll() {
//        return em.createQuery("select u from User u", User.class).getResultList();
//    }
//
//    public List<User> findByName(String name) {
//        return em.createQuery("select u from User u where u.user_name=:name", User.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//
//}
