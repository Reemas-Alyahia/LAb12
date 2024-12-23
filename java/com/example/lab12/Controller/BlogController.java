package com.example.lab12.Controller;

import com.example.lab12.ApiResponse.ApiResponse;
import com.example.lab12.Model.Blog;
import com.example.lab12.Model.MyUser;
import com.example.lab12.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    @GetMapping("/get")
public ResponseEntity getALLBlog(){
    return ResponseEntity.status(200).body(blogService.getAllBlogs());
}

@GetMapping("/get-My-Blogs")
public ResponseEntity getMyBlogs(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getMyBlogs(myUser.getId()));
}

@PostMapping("/add-Blog")
public ResponseEntity addBlog(@RequestBody @Valid Blog blog,@AuthenticationPrincipal MyUser myUser){
        blogService.addBlog(blog, myUser.getId());
        return ResponseEntity.status(200).body(new ApiResponse("Done Added Blog"));
}

    @GetMapping("/get-blog-byId/{blog_id}")
    public ResponseEntity getBlogById(@PathVariable Integer blog_id,@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getBlogById(blog_id, myUser.getId()));
    }


    @GetMapping("/get-blog-byTitle/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title,@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title, myUser.getId()));
    }

    @PutMapping("/update/{blog_id}")
    public ResponseEntity updateBlog(@PathVariable Integer blog_id,@RequestBody @Valid Blog blog,@AuthenticationPrincipal MyUser myUser){
        blogService.updateBlog(blog_id,blog, myUser.getId());
        return ResponseEntity.status(200).body(new ApiResponse("Done Updated Blog"));
    }
    @DeleteMapping("/delete/{blog_id}")
   public ResponseEntity deletBlog(@PathVariable Integer blog_id,@AuthenticationPrincipal MyUser myUser){
        blogService.deleteBlog(blog_id, myUser.getId());
        return ResponseEntity.status(200).body(new ApiResponse("Done Delete Blog"));
}



}
