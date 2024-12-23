package com.example.lab12.Repository;

import com.example.lab12.Model.MyUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
@Registered
public interface AuthRepository extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserByUsername(String username);
   MyUser findMyUserById(Integer id);
}
