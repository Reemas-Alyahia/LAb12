package com.example.lab12.Service;

import com.example.lab12.ApiResponse.ApiException;
import com.example.lab12.Model.Blog;
import com.example.lab12.Model.MyUser;
import com.example.lab12.Repository.AuthRepository;
import com.example.lab12.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private  final BlogRepository blogRepository;
    private  final AuthRepository authRepository;


        public List<Blog> getAllBlogs (){
            return blogRepository.findAll();
        }

        public List<Blog> getMyBlogs(Integer auth){
            MyUser myUser=authRepository.findMyUserById(auth);
            List<Blog> blogList=blogRepository.findBlogByUser(myUser);
            if(blogList.isEmpty()){
                throw new ApiException("There no Blogs Yet");
            }
            return blogList;
        }

         public void addBlog(Blog blog,Integer auth){
            MyUser myUser=authRepository.findMyUserById(auth);
            if(myUser==null){
                throw new ApiException("Usre id not found");
            }
            blog.setUser(myUser);

            blogRepository.save(blog);
         }

       public Blog getBlogById(Integer blog_id, Integer auth){
       Blog blog=blogRepository.findBlogsById(blog_id);
       if (blog==null){
           throw new ApiException("No blogs yet");
       }
       if(blog.getUser().getId()!=auth){
      throw new ApiException("Sorry , You do not have the authority to get this Blog");

       }
       return blog;
    }


    public Blog getBlogByTitle(String title,Integer auth){
        Blog blog=blogRepository.findBlogsByTitle(title);
        if (blog==null){
            throw new ApiException("No blogs yet");
        }
        if(blog.getUser().getId()!=auth){
    throw new ApiException("Sorry , You do not have the authority to get this Blog");

        }
        return blog;
    }

    public void updateBlog(Integer blog_id,Blog blog,Integer auth){
            Blog oldBlog=blogRepository.findBlogsById(blog_id);
            MyUser myUser=authRepository.findMyUserById(auth);
            if(oldBlog==null){
                throw new ApiException("Blog not not found");
            }
            else if(oldBlog.getUser().getId()!=auth){
        throw new ApiException("Sorry , You do not have the authority to update this Blog");
            }
         blog.setId(blog_id);
          blog.setUser(myUser);

          blogRepository.save(blog);

    }

    public void deleteBlog(Integer blog_id,Integer auth) {
        Blog blog = blogRepository.findBlogsById(blog_id);
        if (blog == null) {
            throw new ApiException("Blog not not found");
        }
        else if (blog.getUser().getId() != auth) {
            throw new ApiException("Sorry , You do not have the authority to delete this Blog");

        }
        blogRepository.delete(blog);
    }

}
