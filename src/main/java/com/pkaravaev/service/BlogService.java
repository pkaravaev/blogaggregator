package com.pkaravaev.service;

import com.pkaravaev.model.Blog;
import com.pkaravaev.model.User;
import com.pkaravaev.repository.BlogRepository;
import com.pkaravaev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;


    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);

    }

    public Blog findOne(int id) {
        return blogRepository.getBlogById(id);
    }

    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }
}
