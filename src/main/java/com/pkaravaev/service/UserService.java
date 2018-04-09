package com.pkaravaev.service;

import com.pkaravaev.model.Blog;
import com.pkaravaev.model.Item;
import com.pkaravaev.model.Role;
import com.pkaravaev.model.User;
import com.pkaravaev.repository.BlogRepository;
import com.pkaravaev.repository.ItemRepository;
import com.pkaravaev.repository.RoleRepository;
import com.pkaravaev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    private RoleRepository roleRepository;

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

    @Transactional
    public User findOneWithBlogs(String name) {
        User user = userRepository.findByName(name);
        return findOneWithBlogs(user.getId());
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));


        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(user);
    }



}
