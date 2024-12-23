package com.example.lab12.Service;

import com.example.lab12.ApiResponse.ApiException;
import com.example.lab12.Model.MyUser;
import com.example.lab12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
private final AuthRepository authRepository;


 public List<MyUser>getAllUser(){
     return authRepository.findAll();
 }

    public void register(MyUser myUser){
        MyUser myUser1=authRepository.findMyUserByUsername(myUser.getUsername());
        if(myUser1!=null){
            throw new ApiException("User Already there");
        }
        myUser.setRole("USER");
        String hashPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashPassword);

        authRepository.save(myUser);
    }


    public void updateUser(MyUser myUser,Integer id){
     MyUser oldUser=authRepository.findMyUserById(id);
     if(oldUser==null){
         throw new ApiException("User Not Found");
     }
   myUser.setId(id);
    myUser.setPassword(new BCryptPasswordEncoder().encode(myUser.getPassword()));
     myUser.setRole(myUser.getRole());

    authRepository.save(myUser);

    }


    public void deleteUser(Integer id){
        MyUser myUser=authRepository.findMyUserById(id);
        if(myUser==null){
            throw new ApiException("User Not Found");
        }
        authRepository.delete(myUser);
    }
}


