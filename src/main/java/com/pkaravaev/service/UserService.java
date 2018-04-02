package com.pkaravaev.service;

import com.pkaravaev.model.Blog;
import com.pkaravaev.model.Item;
import com.pkaravaev.model.User;
import com.pkaravaev.repository.BlogRepository;
import com.pkaravaev.repository.ItemRepository;
import com.pkaravaev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private ItemRepository itemRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {

        User user = userRepository.getOne(id);
        return userRepository.getOne(id);
    }

    @Transactional
    public User findOneWithBlogs(int id) {
        User user = userRepository.getUserById(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog : blogs) {
            List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {


        userRepository.save(user);
    }

}
