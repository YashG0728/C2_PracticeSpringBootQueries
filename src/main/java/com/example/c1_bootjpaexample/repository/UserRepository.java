package com.example.c1_bootjpaexample.repository;

import com.example.c1_bootjpaexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
     List<User> findByName(String name);   //introducer =  find , byName = criteria
     List<User> findByNameAndCity(String name,String city);

     @Query("select u FROM User u")
     public List<User> getAllUser();

     @Query("select u FROM User u WHERE u.name =:n")
     public List<User> getUserByName(@Param("n") String name);//@PARAM is used to bind with variable n with name

     @Query("select u FROM User u WHERE u.name =:n and u.city=:c")
     public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);


     @Query(value = "select * from User", nativeQuery = true)
     public List<User> getUser();
}
