package com.example.lab12.Service;

import com.example.lab12.ApiResponse.ApiException;
import com.example.lab12.Model.MyUser;
import com.example.lab12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MyUserDetailsService implements UserDetailsService {
private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser=authRepository.findMyUserByUsername(username);
        if(myUser==null){
       throw new ApiException("Wrong Password or Username");
        }
        return myUser;
    }


}
