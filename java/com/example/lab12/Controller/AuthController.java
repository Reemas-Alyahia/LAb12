package com.example.lab12.Controller;

import com.example.lab12.ApiResponse.ApiResponse;
import com.example.lab12.Model.MyUser;
import com.example.lab12.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthController {
private final AuthService authService;


@GetMapping("/get-All-User") //only Admin
public ResponseEntity getAllMyUser(){
    return ResponseEntity.status(200).body(authService.getAllUser());
}


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Hello to our web"));
    }


    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody @Valid MyUser newUser, @AuthenticationPrincipal MyUser auth){
        authService.updateUser(newUser , auth.getId());
        return ResponseEntity.status(200).body(new ApiResponse("User Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        authService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
    }
}
