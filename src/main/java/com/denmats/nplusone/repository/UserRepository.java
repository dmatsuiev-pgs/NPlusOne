package com.denmats.nplusone.repository;

import com.denmats.nplusone.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where username= :username")
    List<User> findAllByUsername(@Param("username")String username);

    @Query("select u from User u")
    List<User> findAllUsers(Pageable page);

//    @Query("select u from User u left join fetch u.address")
//    List<User> findAllUsers(Pageable page);


//    @Query(value = "select * from user as u " +
//            "left join address as a " +
//            "on u.id = a.user_id"
//            , nativeQuery = true )
//    List<User> findAllUsers();



}

